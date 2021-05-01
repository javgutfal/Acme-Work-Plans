package acme.features.manager.workPlan.tasks;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerWorkPlanTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);

	@Query("select m from Manager m where m.id = ?1")
	Manager findOneManagerById(int id);

	@Query("select t from Task t where t.id in (select c.task.id from ConsistsOf c where c.workPlan.id = ?1)")
	List<Task> findManyTasksByWorkPlanId(int workPlanId);
	
	@Query("select t from Task t where t.id not in (select c.task.id from ConsistsOf c where c.workPlan.id = ?1)")
	List<Task> findManyTasksByNotWorkPlanId(int workPlanId);

}
