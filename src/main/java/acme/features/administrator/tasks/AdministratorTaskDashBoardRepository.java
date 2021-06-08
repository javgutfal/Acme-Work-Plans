package acme.features.administrator.tasks;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTaskDashBoardRepository extends AbstractRepository {
	
	@Query("select count(t) from Task t where t.publicTask = true")
	Long getPublicTaskNumber();
	
	@Query("select count(t) from Task t where t.publicTask = false")
	Long getPrivateTaskNumber();
	
	@Query("select count(t) from Task t where t.finalTime <= current_date()")
	Long getFinishedTaskNumber();
	
	@Query("select count(t) from Task t where t.finalTime > current_date()")
	Long getNotFinishedTaskNumber();
	
	@Query("select avg(datediff(t.finalTime, t.initialTime)) from Task t ")
	Double averageOfExecutionTaskPeriod();
	
	@Query("select sqrt(sum((datediff(t.finalTime, t.initialTime)- (select avg(datediff(t.finalTime, t.initialTime)) from Task t))*(datediff(t.finalTime, t.initialTime) - (select avg(datediff(t.finalTime, t.initialTime)) from Task t)))) from Task t")
	Double deviationOfExecutionTaskPeriod();
	
	@Query("select min(datediff(t.finalTime, t.initialTime)) from Task t ")
	Double minExecutionTaskPeriod();
	
	@Query("select max(datediff(t.finalTime, t.initialTime)) from Task t ")
	Double maxExecutionTaskPeriod();

	@Query("select avg(t.workload) from Task t ")
	Double averageOfTaskWorkload();
	
	@Query("select stddev(t.workload) from Task t ")
	Double deviationOfTaskWorkload();
	
	@Query("select min(t.workload) from Task t ")
	Double minTaskWorkload();
	
	@Query("select max(t.workload) from Task t ")
	Double maxTaskWorkload();


}
