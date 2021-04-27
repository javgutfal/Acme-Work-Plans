package acme.features.anonymous.workPlan;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousWorkPlanListService implements AbstractListService<Anonymous, WorkPlan> {
	
	@Autowired
	protected AnonymousWorkPlanRepository repository;

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
		
		request.unbind(entity, model, "initialTime", "finalTime","workload","manager");
		model.setAttribute("manager", entity.getManager().getUserAccount().getUsername());
		
		final List<String> listaTitulosTareas = entity.getTasks().stream().map(Task::getTitle).collect(Collectors.toList());
		
		if(entity.isPublished()) {
			model.setAttribute("published", "Yes");
		}else {
			model.setAttribute("published", "No");
		}
		
		for(int i = 1; i< listaTitulosTareas.size();i++) {
			listaTitulosTareas.set(i,  " "+listaTitulosTareas.get(i));
		}
		
		model.setAttribute("tasks", listaTitulosTareas);
	}

	@Override
	public Collection<WorkPlan> findMany(final Request<WorkPlan> request) {
		assert request != null;
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		deadline = calendar.getTime();
		
		return this.repository.findByPublicWorkPlanTrue(deadline);
	}

}
