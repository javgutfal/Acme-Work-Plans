package acme.entities.workPlans;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.Entity;
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
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date initialTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finalTime;
	
	@NotNull
	@Valid
	@ManyToMany(mappedBy = "workPlans")
	protected Collection<Task> tasks;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;
	
	public Double workload() {
		Double result;

		result = this.tasks.stream().collect(Collectors.summingDouble(x->x.getWorkload()));
		return result;
	}
	
	protected boolean publicWorkPlan;
	
	protected boolean finalMode;

}
