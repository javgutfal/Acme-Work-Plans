package acme.entities.XXX;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.datatypes.Money;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class XXX extends DomainEntity{

	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Column(unique = true)
	@Valid
	protected String xxx1;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date moment;
	
	@NotNull
	@Valid
	protected Money money;
	
	protected Boolean flag;

}
