package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkPlanDashboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	Long publicWorkPlanNumber;
	
	Long privateWorkPlanNumber;
	
	Long finishedWorkPlanNumber;
	
	Long notFinishedWorkPlanNumber;
	
	Double averageOfExecutionWorkPlanPeriod;
	
	Double deviationOfExecutionWorkPlanPeriod;
	
	Double minExecutionWorkPlanPeriod;
	
	Double maxExecutionWorkPlanPeriod;
	
	Double averageOfWorkPlanWorkload;
	
	Double deviationOfWorkPlanWorkload;
	
	Double minWorkPlanWorkload;
	
	Double maxWorkPlanWorkload;

}
