package acme.features.authenticated.tasks;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.publicTask = true and t.finished = true")
	List<Task> findByPublicTaskTrueAndFinishedTrue();
	
	@Query("select t from Task t where t.id = ?1 and t.publicTask = true and t.finished = true")
	Task findByIdAndPublicTaskTrueAndFinishedTrue(int id);

}
