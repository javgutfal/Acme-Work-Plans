package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDashboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	protected Long publicTaskNumber;
	
	protected Long privateTaskNumber;
	
	protected Long finishedTaskNumber;
	
	protected Long notFinishedTaskNumber;
	
	protected Double averageNumberOfExecutionPeriod;
	
	protected Double deviationNumberOfExecutionPeriod;
	
	protected Double minExecutionPeriod;
	
	protected Double maxExecutionPeriod;
	
	protected Double averageNumberOfWorkload;
	
	protected Double deviationNumberOfWorkload;
	
	protected Double minWorkload;
	
	protected Double maxWorkload;

}
