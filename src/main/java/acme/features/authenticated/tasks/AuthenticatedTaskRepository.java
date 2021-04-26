package acme.features.authenticated.tasks;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.publicTask = true and t.finalTime < ?1 order by t.workload")
	List<Task> findByPublicTaskTrueAndFinishedTrue(Date moment);
	
	@Query("select t from Task t where t.id = ?1 and t.publicTask = true and t.finalTime < ?1 order by t.workload")
	Task findByIdAndPublicTaskTrueAndFinishedTrue(int id, Date moment);

}
