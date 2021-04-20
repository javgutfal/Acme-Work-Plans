/*
 * AdministratorDashboardShowService.java
 *
 * Copyright (C) 2012-2021 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.workplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.WorkPlanDashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorWorkPlanDashboardShowService implements AbstractShowService<Administrator, WorkPlanDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorWorkPlanDashboardRepository repository;

	// AbstractShowService<Administrator, Dashboard> interface ----------------


	@Override
	public boolean authorise(final Request<WorkPlanDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<WorkPlanDashboard> request, final WorkPlanDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"publicWorkPlanNumber", "privateWorkPlanNumber", // 
			"finishedWorkPlanNumber", "notFinishedWorkPlanNumber", //
			"averageOfExecutionWorkPlanPeriod", "deviationOfExecutionWorkPlanPeriod",
			"minExecutionWorkPlanPeriod", "maxExecutionWorkPlanPeriod",
			"averageOfWorkPlanWorkload", "deviationOfWorkPlanWorkload",
			"minWorkPlanWorkload", "maxWorkPlanWorkload");
	}

	@Override
	public WorkPlanDashboard findOne(final Request<WorkPlanDashboard> request) {
		assert request != null;

		WorkPlanDashboard result;
		
		final Long publicWorkPlanNumber;
		final Long privateWorkPlanNumber;
		final Long finishedWorkPlanNumber;
		final Long notFinishedWorkPlanNumber;
		final Double averageOfExecutionWorkPlanPeriod;
		final Double deviationOfExecutionWorkPlanPeriod;
		final Double minExecutionWorkPlanPeriod;
		final Double maxExecutionWorkPlanPeriod;
		final Double averageOfWorkPlanWorkload;
		final Double deviationOfWorkPlanWorkload;
		final Double minWorkPlanWorkload;
		final Double maxWorkPlanWorkload;

		publicWorkPlanNumber = this.repository.getPublicWorkPlanNumber();
		privateWorkPlanNumber = this.repository.getPrivateWorkPlanNumber();
		finishedWorkPlanNumber = this.repository.getFinishedWorkPlanNumber();
		notFinishedWorkPlanNumber = this.repository.getNotFinishedWorkPlanNumber();
		averageOfExecutionWorkPlanPeriod = this.repository.averageOfExecutionWorkPlanPeriod();
		deviationOfExecutionWorkPlanPeriod = this.repository.deviationOfExecutionWorkPlanPeriod();
		minExecutionWorkPlanPeriod = this.repository.minExecutionWorkPlanPeriod();
		maxExecutionWorkPlanPeriod = this.repository.maxExecutionWorkPlanPeriod();
    	averageOfWorkPlanWorkload = this.repository.averageOfWorkPlanWorkload();
		deviationOfWorkPlanWorkload = this.repository.deviationOfWorkPlanWorkload();
		minWorkPlanWorkload = this.repository.minWorkPlanWorkload();
		maxWorkPlanWorkload = this.repository.maxWorkPlanWorkload();

		result = new WorkPlanDashboard();
		result.setPublicWorkPlanNumber(publicWorkPlanNumber);
		result.setPrivateWorkPlanNumber(privateWorkPlanNumber);
		result.setFinishedWorkPlanNumber(finishedWorkPlanNumber);
		result.setNotFinishedWorkPlanNumber(notFinishedWorkPlanNumber);
		result.setAverageOfExecutionWorkPlanPeriod(averageOfExecutionWorkPlanPeriod);
		result.setDeviationOfExecutionWorkPlanPeriod(deviationOfExecutionWorkPlanPeriod);
		result.setMinExecutionWorkPlanPeriod(minExecutionWorkPlanPeriod);
		result.setMaxExecutionWorkPlanPeriod(maxExecutionWorkPlanPeriod);
		result.setAverageOfWorkPlanWorkload(averageOfWorkPlanWorkload);
		result.setDeviationOfWorkPlanWorkload(deviationOfWorkPlanWorkload);
		result.setMinWorkPlanWorkload(minWorkPlanWorkload);
		result.setMaxWorkPlanWorkload(maxWorkPlanWorkload);


		return result;
	}

}
