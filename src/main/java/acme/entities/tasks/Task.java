package acme.entities.tasks;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.workPlans.WorkPlan;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	
	@NotBlank
	@Length(min = 1, max = 80)
	protected String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@FutureOrPresent
	@NotNull
	protected Date initialTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected Date finalTime;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	protected Double workload;
	
	@NotBlank
	@Length(min = 1, max = 500)
	protected String description;
	
	@NotNull
	@Valid
	@ManyToMany()
	protected Collection<WorkPlan> workPlans;
	
	@URL
	protected String link;
	
	protected boolean publicTask;
	
	protected boolean finished;

}
