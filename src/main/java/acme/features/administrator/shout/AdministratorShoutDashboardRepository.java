/*
 * AdministratorDashboardRepository.java
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

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorShoutDashboardRepository extends AbstractRepository {



	@Query("select avg(w.xxx) from Shout w where w.xxx.money.currency='EUR'")
	Double averageOfShoutCurrencyEUR();

	@Query("select avg(w.xxx) from Shout w where w.xxx.money.currency='USD'")
	Double averageOfShoutCurrencyUSD();
	
	@Query("select stddev(w.xxx) from Shout w where w.xxx.money.currency='EUR'")
	Double deviationOfShoutCurrencyEUR();
	
	@Query("select stddev(w.xxx) from Shout w where w.xxx.money.currency='USD'")
	Double deviationOfShoutCurrencyUSD();

	@Query("select count(w) from Shout w where w.xxx.flag = true")
	Double ratioOfShoutsFlagged();

	@Query("select count(w) from Shout w where w.xxx.money.amount>4")
	Double ratioOfShoutsXXX();
	
	@Query("select count(w) from Shout w")
	Double totalShoutsXXX();

}
