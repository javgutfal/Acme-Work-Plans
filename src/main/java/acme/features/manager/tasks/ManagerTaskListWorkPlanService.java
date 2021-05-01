package acme.features.manager.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.features.manager.workPlan.tasks.ManagerWorkPlanTaskRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class ManagerTaskListWorkPlanService implements AbstractListService<Manager, Task> {
	
	@Autowired
	protected ManagerWorkPlanTaskRepository repository;

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

		result = this.repository.findManyTasksByWorkPlanId(request.getModel().getInteger("workPlanId"));

		return result;
	}

}
