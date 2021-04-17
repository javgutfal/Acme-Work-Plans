package acme.features.administrator.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;


public class AdministratorTaskListService implements AbstractListService<Administrator, Task> {
	
	@Autowired
	protected AdministratorTaskRepository repository;

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
		
		request.unbind(entity, model, "title", "initialTime", "finalTime", "workload", "description", "link", "publicTask", "finished");
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		assert request != null;
		
		return this.repository.findAllTasks();
	}

}
