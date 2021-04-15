package acme.features.anonymous.tasks;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t where t.publicTask = true and t.finished = false")
	List<Task> findByPublicTaskTrueAndFinishedFalse();
	
	@Query("select t from Task t where t.id = ?1 and t.publicTask = true and t.finished = false")
	Task findByIdAndPublicTaskTrueAndFinishedFalse(int id);

}
