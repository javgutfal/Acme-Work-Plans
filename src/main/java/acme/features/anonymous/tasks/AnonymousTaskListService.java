package acme.features.anonymous.tasks;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTaskListService implements AbstractListService<Anonymous, Task> {
	
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
		
		request.unbind(entity, model, "title", "initialTime", "finalTime", "workload", "description", "link", "publicTask");

		if(entity.isPublicTask()) {
			model.setAttribute("publicTask", "Yes");
		}else {
			model.setAttribute("publicTask", "No");
		}
	}

	@Override
	public Collection<Task> findMany(final Request<Task> request) {
		assert request != null;
		
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		deadline = calendar.getTime();
		
		return this.repository.findByPublicTaskTrueAndFinishedFalse(deadline);
	}

}
