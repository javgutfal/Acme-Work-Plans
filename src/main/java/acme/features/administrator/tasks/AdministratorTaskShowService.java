package acme.features.administrator.tasks;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;


public class AdministratorTaskShowService implements AbstractShowService<Administrator, Task> {
	
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
	public Task findOne(final Request<Task> request) {
		assert request != null;
		
		return this.repository.findOneById(request.getModel().getInteger("id"));
	}

}
