package acme.features.administrator.spamWords;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spam.SpamWord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamWordRepository extends AbstractRepository {
	
	@Query("select sw from SpamWord sw order by sw.wordEn")
	List<SpamWord> findAllSpamWord();
	
	@Query("select sw from SpamWord sw where sw.id = ?1")
	SpamWord findOneById(int id);

}
