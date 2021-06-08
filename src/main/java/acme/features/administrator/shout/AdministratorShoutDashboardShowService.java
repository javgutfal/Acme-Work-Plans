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

package acme.features.administrator.shout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.ShoutDashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorShoutDashboardShowService implements AbstractShowService<Administrator, ShoutDashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorShoutDashboardRepository repository;

	// AbstractShowService<Administrator, Dashboard> interface ----------------


	@Override
	public boolean authorise(final Request<ShoutDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ShoutDashboard> request, final ShoutDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, //
			"averageOfShoutCurrencyEUR",
			"averageOfShoutCurrencyUSD",
			 "deviationOfShoutCurrencyEUR",
			 "deviationOfShoutCurrencyUSD",
			 "ratioOfShoutsFlagged",
			 "ratioOfShoutsXXX");
	}

	@Override
	public ShoutDashboard findOne(final Request<ShoutDashboard> request) {
		assert request != null;

		ShoutDashboard result;
		
		final Double averageOfShoutCurrencyEUR;
		final Double averageOfShoutCurrencyUSD;
		final Double deviationOfShoutCurrencyEUR;
		final Double deviationOfShoutCurrencyUSD;
		final Double ratioOfShoutsFlagged;
		final Double ratioOfShoutsXXX;
		final Double totalShoutsXXX;

		averageOfShoutCurrencyEUR = this.repository.averageOfShoutCurrencyEUR();
		averageOfShoutCurrencyUSD = this.repository.averageOfShoutCurrencyUSD();
		deviationOfShoutCurrencyEUR = this.repository.deviationOfShoutCurrencyEUR();
		deviationOfShoutCurrencyUSD = this.repository.deviationOfShoutCurrencyUSD();
		ratioOfShoutsFlagged = this.repository.ratioOfShoutsFlagged();
		ratioOfShoutsXXX = this.repository.ratioOfShoutsXXX();
		totalShoutsXXX=this.repository.totalShoutsXXX();
		

		result = new ShoutDashboard();
		result.setAverageOfShoutCurrencyEUR(averageOfShoutCurrencyEUR);
		result.setAverageOfShoutCurrencyUSD(averageOfShoutCurrencyUSD);
		result.setDeviationOfShoutCurrencyEUR(deviationOfShoutCurrencyEUR);
		result.setDeviationOfShoutCurrencyUSD(deviationOfShoutCurrencyUSD);
		result.setRatioOfShoutsFlagged(ratioOfShoutsFlagged/totalShoutsXXX);
		result.setRatioOfShoutsXXX(ratioOfShoutsXXX/totalShoutsXXX);


		return result;
	}



}
