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
	
	protected Long publicWorkPlanNumber;
	
	protected Long privateWorkPlanNumber;
	
	protected Long finishedWorkPlanNumber;
	
	protected Long notFinishedWorkPlanNumber;
	
	protected Double averageOfExecutionWorkPlanPeriod;
	
	protected Double deviationOfExecutionWorkPlanPeriod;
	
	protected Double minExecutionWorkPlanPeriod;
	
	protected Double maxExecutionWorkPlanPeriod;
	
	protected Double averageOfWorkPlanWorkload;
	
	protected Double deviationOfWorkPlanWorkload;
	
	protected Double minWorkPlanWorkload;
	
	protected Double maxWorkPlanWorkload;

}
