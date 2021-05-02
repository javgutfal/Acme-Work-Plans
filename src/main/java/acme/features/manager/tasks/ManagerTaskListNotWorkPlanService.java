package acme.features.manager.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListNotWorkPlanService implements AbstractListService<Manager, Task> {
	
	@Autowired
	protected ManagerTaskRepository repository;

	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "initialTime", "finalTime", "workload", "description", "link", "publicTask");
		model.setAttribute("workPlanId", request.getModel().getInteger("workPlanId"));
		model.setAttribute("isWorkPlan", true);
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		assert request != null;
		
		final Collection<Task> result;
		WorkPlan workPlan;
		int id;
		id = request.getModel().getInteger("workPlanId");
		
		workPlan = this.repository.findOneWorkPlanById(id);
		
		if(workPlan.isPublicWorkPlan()) {
			result = this.repository.findManyTasksByNotWorkPlanPublicId(id,workPlan.getInitialTime(), workPlan.getFinalTime());
		}else {
			result = this.repository.findManyTasksByNotWorkPlanId(id,workPlan.getInitialTime(), workPlan.getFinalTime());
		}
		

		return result;
	}

}
