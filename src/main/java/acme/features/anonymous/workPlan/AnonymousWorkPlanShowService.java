package acme.features.anonymous.workPlan;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.workPlans.WorkPlan;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;


public class AnonymousWorkPlanShowService implements AbstractShowService<Anonymous, WorkPlan> {
	
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
		
		request.unbind(entity, model, "initialTime", "finalTime", "workload", "description", "link");
	}

	@Override
	public WorkPlan findOne(final Request<WorkPlan> request) {
		assert request != null;
		Calendar calendar;
		Date deadline;

		calendar = Calendar.getInstance();
		deadline = calendar.getTime();
		
		return this.repository.findByIdAndPublicWorkPlanTrue(request.getModel().getInteger("id"),deadline);
	}

}
