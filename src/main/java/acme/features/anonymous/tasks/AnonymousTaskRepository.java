package acme.features.anonymous.tasks;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.publicTask = true and t.finalTime >= ?1 order by t.workload")
	List<Task> findByPublicTaskTrueAndFinishedFalse(Date deadline);
	
	@Query("select t from Task t where t.id = ?1 and t.publicTask = true and t.finalTime >= ?1 order by t.workload")
	Task findByIdAndPublicTaskTrueAndFinishedFalse(int id, Date moment);
	
	@Query("select c.task from ConsistsOf c where c.workPlan.id = ?1 ")
	List<Task> findByPublicTasksByWorkPlanId(int workPlanId);

}
