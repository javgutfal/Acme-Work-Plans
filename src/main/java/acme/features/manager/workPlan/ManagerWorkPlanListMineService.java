package acme.features.manager.workPlan;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class ManagerWorkPlanListMineService implements AbstractListService<Manager, WorkPlan> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerWorkPlanRepository repository;


	@Override
	public boolean authorise(final Request<WorkPlan> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<WorkPlan> request, final WorkPlan entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		Calendar calendar;
		Date actualDate;
					
		calendar = new GregorianCalendar();
		actualDate = calendar.getTime();

		request.unbind(entity, model, "initialTime", "finalTime","workload");
		final List<String> listaTitulosTareas = entity.getTasks().stream().map(Task::getTitle).collect(Collectors.toList());
		
		for(int i = 1; i< listaTitulosTareas.size();i++) {
			listaTitulosTareas.set(i,  " "+listaTitulosTareas.get(i));
		}
		
		model.setAttribute("inicialMoment", actualDate);
		model.setAttribute("tasks", listaTitulosTareas);
	}

	@Override
	public Collection<WorkPlan> findMany(final Request<WorkPlan> request) {
		assert request != null;

		Collection<WorkPlan> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByManagerId(principal.getActiveRoleId());

		return result;
	}

}
