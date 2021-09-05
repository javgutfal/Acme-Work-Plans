package acme.features.manager.workPlan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class ManagerWorkPlanPublishService implements AbstractUpdateService<Manager, WorkPlan> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerWorkPlanRepository repository;


	@Override
	public boolean authorise(final Request<WorkPlan> request) {
		assert request != null;

		boolean result;
		int workPlanId;
		WorkPlan workPlan;
		Manager manager;
		Principal principal;

		workPlanId = request.getModel().getInteger("id");
		workPlan = this.repository.findOneWorkPlanById(workPlanId);
		manager = workPlan.getManager();
		principal = request.getPrincipal();
		result = manager.getUserAccount().getId() == principal.getAccountId() && !workPlan.isPublished();

		return result;
	}

	@Override
	public void validate(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		WorkPlan workPlan;
		workPlan = this.repository.findOneWorkPlanById(entity.getId());
		
		final Date initialTime = this.repository.findEarliestInitialTimeTaskByWorkPlanId(entity.getId());		
		final Date finalTime = this.repository.findLatestFinalTimeTaskByWorkPlanId(entity.getId());
		if (!errors.hasErrors("initialTime")) {
			Calendar calendar;
			Date actualDate;
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			
			if(initialTime != null) {
				errors.state(request, entity.getInitialTime().equals(initialTime) || entity.getInitialTime().before(initialTime), "initialTime", "manager.work-plan.form.error.initialTimeTask");
			}
			errors.state(request, workPlan.getInitialTime().compareTo(entity.getInitialTime())==0 || entity.getInitialTime().after(actualDate), "initialTime", "manager.work-plan.form.error.initialTime");
		}
		
		if (!errors.hasErrors("finalTime")) {
			Calendar calendar;
			Date actualDate;
						
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			if(finalTime != null) {
				errors.state(request, entity.getFinalTime().equals(finalTime) || entity.getFinalTime().after(finalTime), "finalTime", "manager.work-plan.form.error.finalTimeTask");

			}
			errors.state(request, workPlan.getFinalTime().compareTo(entity.getFinalTime())==0 || entity.getFinalTime().after(actualDate), "finalTime", "manager.work-plan.form.error.finalTime");
			if(entity.getInitialTime() != null) {
				errors.state(request, entity.getFinalTime().after(entity.getInitialTime()), "finalTime", "manager.work-plan.form.error.finalTimeInitial");
			}
		}

	}

	@Override
	public void bind(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<WorkPlan> request, final WorkPlan entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		final Calendar newInitialTime = Calendar.getInstance();
		final Calendar newFinalTime = Calendar.getInstance();
		final Calendar actualDate = Calendar.getInstance();
		Date initialTime;
		Date finalTime;
		
		request.unbind(entity, model, "initialTime", "finalTime","publicWorkPlan");
		
		initialTime = this.repository.findInitialTimeManyConsistsOfById(entity.getId());
		
		if(initialTime != null) {
		
			
			
			newInitialTime.setTime(initialTime);
			newInitialTime.set(Calendar.HOUR, 8);
			newInitialTime.set(Calendar.MINUTE, 0);
			newInitialTime.add(Calendar.DATE, -1);
			
			if(newInitialTime.before(actualDate)) {
				newInitialTime.setTime(initialTime);
			}
			
			
			finalTime = this.repository.findFinalTimeManyConsistsOfById(entity.getId());
			
			newFinalTime.setTime(finalTime);
			newFinalTime.set(Calendar.HOUR, 17);
			newFinalTime.set(Calendar.MINUTE, 0);
			newFinalTime.add(Calendar.DATE, +1);
			
			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");  
			final String strDateInitialTime = dateFormat.format(newInitialTime.getTime());
			final String strDateFinalTime = dateFormat.format(newFinalTime.getTime());
			model.setAttribute("fechaSugerida", strDateInitialTime+ " - "+strDateFinalTime);
		
		}else {
			model.setAttribute("fechaSugerida", false);
		}
	}

	@Override
	public WorkPlan findOne(final Request<WorkPlan> request) {
		assert request != null;

		WorkPlan result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneWorkPlanById(id);

		return result;
	}

	@Override
	public void update(final Request<WorkPlan> request, final WorkPlan entity) {
		assert request != null;
		assert entity != null;

		entity.setPublished(true);
		this.repository.save(entity);
	}

}
