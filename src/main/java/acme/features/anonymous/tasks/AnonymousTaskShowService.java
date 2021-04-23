package acme.features.anonymous.tasks;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;


public class AnonymousTaskShowService implements AbstractShowService<Anonymous, Task> {
	
	@Autowired
	protected AnonymousTaskRepository repository;

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
		
		request.unbind(entity, model, "title", "initialTime", "finalTime", "workload", "description", "link");
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		deadline = calendar.getTime();
		
		return this.repository.findByIdAndPublicTaskTrueAndFinishedFalse(request.getModel().getInteger("id"),deadline);
	}

}
