package acme.features.manager.tasks;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.consistsOf.ConsistsOf;
import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.entities.workPlans.WorkPlan;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);
	
	@Query("select w from WorkPlan w where w.id = ?1")
	WorkPlan findOneWorkPlanById(int id);

	@Query("select m from Manager m where m.id = ?1")
	Manager findOneManagerById(int id);

	@Query("select t from Task t where t.manager.id = ?1")
	List<Task> findManyByManagerId(int managerId);
	
	@Query("select t from Task t where t.id in (select c.task.id from ConsistsOf c where c.workPlan.id = ?1)")
	List<Task> findManyTasksByWorkPlanId(int workPlanId);
	
	@Query("select t from Task t where t.initialTime >= ?2  and t.manager.id = ?4 and t.finalTime<= ?3 and t.id not in (select c.task.id from ConsistsOf c where c.workPlan.id = ?1)")
	List<Task> findManyTasksByNotWorkPlanId(int workPlanId, Date initialTime, Date finalTime, Integer managerId);
	
	@Query("select t from Task t where t.publicTask = true and t.manager.id = ?4 and t.initialTime >= ?2 and t.finalTime<= ?3 and t.id not in (select c.task.id from ConsistsOf c where c.workPlan.id = ?1)")
	List<Task> findManyTasksByNotWorkPlanPublicId(int workPlanId, Date initialTime, Date finalTime, Integer managerId);
	
	@Query("select c from ConsistsOf c where c.task.id = ?1 and c.workPlan.id = ?2")
	ConsistsOf findOneConsistsOfById(int taskId, int workplanId);
	
	@Query("select c from ConsistsOf c where c.task.id = ?1")
	List<ConsistsOf> findManyConsistsOfById(int taskId);

}
