/*
 * WorkerApplicationCreateService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.manager.consistsOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.consistsOf.ConsistsOf;
import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerConsistsOfCreateService implements AbstractCreateService<Manager, ConsistsOf> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerConsistsOfRepository repository;

	// AbstractCreateService<Worker, Application> interface -------------------


	@Override
	public boolean authorise(final Request<ConsistsOf> request) {
		assert request != null;
		
		boolean managerValidation;
		WorkPlan workPlan;
		Manager manager;
		Principal principal;
		Task task;

		workPlan = this.repository.findOneWorkPlanById(request.getModel().getInteger("workPlanId"));
		task = this.repository.findOneTaskById(request.getModel().getInteger("taskId"));

		manager = workPlan.getManager();
		principal = request.getPrincipal();
		managerValidation = manager.getUserAccount().getId() == principal.getAccountId();
		
		
		
		if(workPlan.isPublicWorkPlan()) {
			return task.isPublicTask() && workPlan.getInitialTime().equals(task.getInitialTime()) 
				|| workPlan.getFinalTime().equals(task.getFinalTime()) && managerValidation|| workPlan.getInitialTime().before(task.getInitialTime())
				&& workPlan.getFinalTime().after(task.getFinalTime());
		}else {
			return workPlan.getInitialTime().equals(task.getInitialTime())
				|| workPlan.getFinalTime().equals(task.getFinalTime()) && managerValidation
				|| workPlan.getInitialTime().before(task.getInitialTime())
				&& workPlan.getFinalTime().after(task.getFinalTime());
		}

	}

	@Override
	public void bind(final Request<ConsistsOf> request, final ConsistsOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<ConsistsOf> request, final ConsistsOf entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
		model.setAttribute("taskId", entity.getTask().getId());
		model.setAttribute("workPlanId", entity.getWorkPlan().getId());
	}

	@Override
	public ConsistsOf instantiate(final Request<ConsistsOf> request) {
		assert request != null;

		ConsistsOf result;
		WorkPlan workPlan;
		Task task;

		workPlan = this.repository.findOneWorkPlanById(request.getModel().getInteger("workPlanId"));
		task = this.repository.findOneTaskById(request.getModel().getInteger("taskId"));
		result = new ConsistsOf();
		result.setTask(task);
		result.setWorkPlan(workPlan);

		return result;
	}

	@Override
	public void validate(final Request<ConsistsOf> request, final ConsistsOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<ConsistsOf> request, final ConsistsOf entity) {
		assert request != null;
		assert entity != null;
		WorkPlan workPlan;
		
		workPlan = entity.getWorkPlan();
		workPlan.setWorkload(workPlan.getWorkload()+entity.getTask().getWorkload());
		entity.setWorkPlan(workPlan);
		this.repository.save(workPlan);
		this.repository.save(entity);
	}

}
