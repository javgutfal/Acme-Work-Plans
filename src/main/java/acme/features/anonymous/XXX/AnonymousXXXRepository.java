package acme.features.anonymous.XXX;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.XXX.XXX;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousXXXRepository extends AbstractRepository {

	@Query("select w from XXX w where w.id = ?1")
	XXX findOneXXXById(int xxxId);
	
	@Query("select w from XXX w where w.xxx1 = ?1")
	XXX findOneByXXX1(String xxx1);

}
