/*
 * WorkerApplicationRepository.java
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

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.consistsOf.ConsistsOf;
import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerConsistsOfRepository extends AbstractRepository {

	@Query("select c from ConsistsOf c where c.id = ?1")
	ConsistsOf findOneConsistsOfById(int id);

	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);

	@Query("select w from WorkPlan w where w.id = ?1")
	WorkPlan findOneWorkPlanById(int id);

	@Query("select c from ConsistsOf c where c.workPlan.id = ?1")
	Collection<ConsistsOf> findManyConsistsOfByWorkPlanId(int id);

}
