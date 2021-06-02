package acme.entities.spam;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpamWord extends DomainEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@Length(min = 1, max = 150)
	protected String wordEn;
	
	@NotBlank
	@Length(min = 1, max = 150)
	protected String wordEs;

}
