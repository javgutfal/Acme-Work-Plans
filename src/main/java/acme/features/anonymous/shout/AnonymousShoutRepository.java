package acme.features.anonymous.shout;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutRepository extends AbstractRepository {

	//@Query("select s from Shout s")
	//Collection<Shout> findMany();
	
	@Query(value = "select * from Shout where moment > CURRENT_DATE() - INTERVAL 30 DAY ORDER BY moment", nativeQuery=true)
	Collection<Shout> findNotOlderMonth();

}
