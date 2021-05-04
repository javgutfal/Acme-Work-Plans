package acme.features.manager.workPlan;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.consistsOf.ConsistsOf;
import acme.entities.roles.Manager;
import acme.entities.workPlans.WorkPlan;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerWorkPlanRepository extends AbstractRepository {

	@Query("select w from WorkPlan w where w.id = ?1")
	WorkPlan findOneWorkPlanById(int id);

	@Query("select m from Manager m where m.id = ?1")
	Manager findOneManagerById(int id);

	@Query("select w from WorkPlan w where w.manager.id = ?1")
	Collection<WorkPlan> findManyByManagerId(int managerId);

	@Query("select c from ConsistsOf c where c.workPlan.id = ?1")
	List<ConsistsOf> findManyConsistsOfById(int workPlanId);
	
	@Query("select min(c.task.initialTime) from ConsistsOf c where c.workPlan.id = ?1")
	Date findInitialTimeManyConsistsOfById(int workPlanId);
	
	@Query("select max(c.task.finalTime) from ConsistsOf c where c.workPlan.id = ?1")
	Date findFinalTimeManyConsistsOfById(int workPlanId);
	
	@Query("select c.task.publicTask from ConsistsOf c where c.workPlan.id = ?1 and c.task.publicTask = false")
	List<Boolean> findManyTasksPrivateById(int workPlanId);
}
