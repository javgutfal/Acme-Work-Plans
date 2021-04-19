package acme.entities.tasks;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.roles.Manager;
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
	@NotNull
	protected Date initialTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date finalTime;
	
	@NotNull
	@Digits(integer = 10, fraction = 2)
	protected Double workload;
	
	@NotBlank
	@Length(min = 1, max = 500)
	protected String description;
	
	
	@Valid
	@ManyToMany()
	protected Collection<WorkPlan> workPlans;
	
	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;
	
	@URL
	protected String link;
	
	protected boolean publicTask;
	
	protected boolean finished;

}
