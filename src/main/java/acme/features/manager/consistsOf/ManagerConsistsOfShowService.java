/*
 * WorkerApplicationShowService.java
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
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class ManagerConsistsOfShowService implements AbstractShowService<Manager, ConsistsOf> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected ManagerConsistsOfRepository repository;

	// AbstractShowService<Worker, Application> interface ---------------------


	@Override
	public boolean authorise(final Request<ConsistsOf> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ConsistsOf> request, final ConsistsOf entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
		model.setAttribute("workPlanId", entity.getWorkPlan().getId());
		model.setAttribute("taskId", entity.getTask().getId());
	}

	@Override
	public ConsistsOf findOne(final Request<ConsistsOf> request) {
		assert request != null;

		ConsistsOf result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneConsistsOfById(id);

		return result;
	}

}
