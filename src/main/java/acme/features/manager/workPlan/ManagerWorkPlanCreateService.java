package acme.features.manager.workPlan;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.workPlans.WorkPlan;
import acme.features.generic.spam.GenericSpamService;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerWorkPlanCreateService implements AbstractCreateService<Manager, WorkPlan> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerWorkPlanRepository repository;
	
	@Autowired
	protected GenericSpamService spamService;

	@Override
	public boolean authorise(final Request<WorkPlan> request) {
		assert request != null;

		return true;
	}

	@Override
	public void validate(final Request<WorkPlan> request, final WorkPlan entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("initialTime")) {
			Calendar calendar;
			Date actualDate;
						
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			errors.state(request, entity.getInitialTime().after(actualDate), "initialTime", "manager.work-plan.form.error.initialTime");
		}
		
		if (!errors.hasErrors("finalTime")) {
			Calendar calendar;
			Date actualDate;
						
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			errors.state(request, entity.getFinalTime().after(actualDate), "finalTime", "manager.work-plan.form.error.finalTime");
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

		request.unbind(entity, model, "initialTime", "finalTime","publicWorkPlan");
	}

	@Override
	public WorkPlan instantiate(final Request<WorkPlan> request) {
		assert request != null;

		WorkPlan result;
		Manager manager;

		manager = this.repository.findOneManagerById(request.getPrincipal().getActiveRoleId());
		result = new WorkPlan();
		result.setManager(manager);
		result.setPublicWorkPlan(false);

		return result;
	}

	@Override
	public void create(final Request<WorkPlan> request, final WorkPlan entity) {
		assert request != null;
		assert entity != null;
		entity.setPublished(false);
		entity.setWorkload(0.);
		this.repository.save(entity);
	}

}
