package acme.features.manager.consistsOf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.consistsOf.ConsistsOf;
import acme.entities.roles.Manager;
import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class ManagerConsistsOfDeleteService implements AbstractDeleteService<Manager, ConsistsOf> {
	
	@Autowired
	protected ManagerConsistsOfRepository repository;

	@Override
	public boolean authorise(final Request<ConsistsOf> request) {
		assert request != null;

		boolean result;
		int workplanId;
		WorkPlan workPlan;
		Manager manager;
		Principal principal;

		workplanId = request.getModel().getInteger("workPlanId");
		workPlan = this.repository.findOneWorkPlanById(workplanId);
		manager = workPlan.getManager();
		principal = request.getPrincipal();
		result = manager.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<ConsistsOf> request, final ConsistsOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void unbind(final Request<ConsistsOf> request, final ConsistsOf entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

	}

	@Override
	public ConsistsOf findOne(final Request<ConsistsOf> request) {
		assert request != null;

		ConsistsOf result;
		int taskId;
		int workplanId;
		taskId = request.getModel().getInteger("taskId");
		workplanId = request.getModel().getInteger("workPlanId");
		result = this.repository.findOneConsistsOfById(taskId,workplanId);

		return result;
	}

	@Override
	public void validate(final Request<ConsistsOf> request, final ConsistsOf entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<ConsistsOf> request, final ConsistsOf entity) {
		assert request != null;
		assert entity != null;
		WorkPlan workPlan;
		
		workPlan = entity.getWorkPlan();
		workPlan.setWorkload(workPlan.getWorkload()-entity.getTask().getWorkload());
		this.repository.save(workPlan);
		entity.setWorkPlan(workPlan);
		this.repository.delete(entity);
	}

}
