package acme.features.manager.tasks;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.features.generic.spam.GenericSpamService;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class ManagerTaskUpdateService implements AbstractUpdateService<Manager, Task> {
	
	@Autowired
	protected ManagerTaskRepository repository;
	
	@Autowired
	protected GenericSpamService spamService;

	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;

		boolean result;
		int taskId;
		Task task;
		Manager manager;
		Principal principal;

		taskId = request.getModel().getInteger("id");
		task = this.repository.findOneTaskById(taskId);
		manager = task.getManager();
		principal = request.getPrincipal();
		result = manager.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "initialTime", "finalTime", "workload", "description", "link", "publicTask");
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;

		Task result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneTaskById(id);

		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if (!errors.hasErrors("initialTime")) {
			Calendar calendar;
			Date actualDate;
						
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			errors.state(request, entity.getInitialTime().after(actualDate), "initialTime", "manager.task.form.error.initialTime");
		}
		
		if (!errors.hasErrors("finalTime")) {
			Calendar calendar;
			Date actualDate;
						
			calendar = new GregorianCalendar();
			actualDate = calendar.getTime();
			errors.state(request, entity.getFinalTime().after(actualDate), "finalTime", "manager.task.form.error.finalTime");
			errors.state(request, entity.getFinalTime().after(entity.getInitialTime()), "finalTime", "manager.task.form.error.finalTimeInitial");
		}
		
		if (!errors.hasErrors("workload")) {
			final Long diferencia = entity.getFinalTime().getTime() - entity.getInitialTime().getTime();

			errors.state(request, entity.getWorkload()>=0, "workload", "manager.task.form.error.workload");
			errors.state(request, entity.getWorkload()<= diferencia/3600000, "workload", "manager.task.form.error.workloadExecution");
		}
		
		if (!errors.hasErrors("title")) {
			String text;
			
			text = entity.getTitle().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "title", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("description")) {
			String text;
			
			text = entity.getDescription().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "description", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("link")) {
			String text;
			
			text = entity.getLink().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "link", "anonymous.shout.form.error.spam");
		}
	
	}

	@Override
	public void update(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
