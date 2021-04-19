package acme.features.administrator.tasks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTaskRepository extends AbstractRepository {
	
	@Query("select count(t) from Task t where t.publicTask = true")
	Long getPublicTaskNumber();
	
	@Query("select count(t) from Task t where t.publicTask = false")
	Long getPrivateTaskNumber();
	
	@Query("select count(t) from Task t where t.finished = true")
	Long getFinishedTaskNumber();
	
	@Query("select count(t) from Task t where t.finished = false")
	Long getNotFinishedTaskNumber();
	
//	Double averageNumberOfExecutionPeriod();
//	
//	Double deviationNumberOfExecutionPeriod();
//	
//	Double minExecutionPeriod();
//	
//	Double maxExecutionPeriod();
//	
//	Double averageNumberOfWorkload();
//	
//	Double deviationNumberOfWorkload();
//	
//	Double minWorkload();
//	
//	Double maxWorkload();

}
