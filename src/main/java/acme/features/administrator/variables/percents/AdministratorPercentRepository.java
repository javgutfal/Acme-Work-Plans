package acme.features.administrator.variables.percents;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.variables.Percent;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorPercentRepository extends AbstractRepository {
	
	@Query("select p from Percent p order by p.code")
	List<Percent> findAllPercents();
	
	@Query("select p from Percent p where p.id = ?1")
	Percent findOneById(int id);

}
