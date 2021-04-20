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

package acme.features.administrator.workplan;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorWorkPlanDashboardRepository extends AbstractRepository {

	@Query("select count(w) from WorkPlan w where w.publicWorkPlan = true")
	Long getPublicWorkPlanNumber();
	
	@Query("select count(w) from WorkPlan w where w.publicWorkPlan = false")
	Long getPrivateWorkPlanNumber();
	
	@Query("select count(w) from WorkPlan w where w.finalTime > current_date()")
	Long getFinishedWorkPlanNumber();
	
	@Query("select count(w) from WorkPlan w where w.finalTime <= current_date()")
	Long getNotFinishedWorkPlanNumber();
	
	@Query("select avg(datediff(w.finalTime, w.initialTime)) from WorkPlan w ")
	Double averageOfExecutionWorkPlanPeriod();
	
	@Query("select STDEV(datediff(w.finalTime, w.initialTime)) from WorkPlan w ")
	Double deviationOfExecutionWorkPlanPeriod();
	
	@Query("select min(datediff(w.finalTime, w.initialTime)) from WorkPlan w ")
	Double minExecutionWorkPlanPeriod();
	
	@Query("select max(datediff(w.finalTime, w.initialTime)) from WorkPlan w ")
	Double maxExecutionWorkPlanPeriod();

	@Query("select avg(w.workload) from WorkPlan w ")
	Double averageOfWorkPlanWorkload();
	
	@Query("select avg(w.workload) from WorkPlan w ")
	Double deviationOfWorkPlanWorkload();
	
	@Query("select min(w.workload) from WorkPlan w ")
	Double minWorkPlanWorkload();
	
	@Query("select max(w.workload) from WorkPlan w ")
	Double maxWorkPlanWorkload();

}
