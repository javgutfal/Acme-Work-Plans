package acme.features.anonymous.workPlan;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.workPlans.WorkPlan;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousWorkPlanRepository extends AbstractRepository {
	
	@Query("select w from WorkPlan w where w.publicWorkPlan = true and w.finalTime > ?1")
	List<WorkPlan> findByPublicWorkPlanTrue(Date moment);
	
	@Query("select w from WorkPlan w where w.id = ?1 and w.publicWorkPlan = true and w.finalTime <= ?1")
	WorkPlan findByIdAndPublicWorkPlanTrue(int id, Date moment);

}
