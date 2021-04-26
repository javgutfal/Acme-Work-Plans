package acme.entities.workPlans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.entities.roles.Manager;
import acme.entities.tasks.Task;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkPlan extends DomainEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	@Column(name = "initial_time")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date initialTime;
	
	@Column(name = "final_time")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finalTime;
	
	@Valid
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "workPlans",cascade = CascadeType.ALL)
	protected List<Task> tasks;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;
	
	protected Double workload;
	
	protected boolean publicWorkPlan;
	
	protected boolean published;
	

}
