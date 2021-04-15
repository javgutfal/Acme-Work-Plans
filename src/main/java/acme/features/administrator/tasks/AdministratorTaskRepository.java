package acme.features.administrator.tasks;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTaskRepository extends AbstractRepository {
	
	@Query("select t from Task t")
	List<Task> findAllTasks();
	
	@Query("select t from Task t where t.id = ?1")
	Task findOneById(int id);

}
