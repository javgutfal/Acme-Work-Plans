package acme.features.generic.spam;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spam.SpamWord;
import acme.entities.variables.Percent;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface GenericSpamRepository extends AbstractRepository {
	
	@Query("select sw from SpamWord sw")
	List<SpamWord> findAllSpamWords();
	
	@Query("select p from Percent p where p.code = ?1")
	Percent findPercentByCode(String code);

}
