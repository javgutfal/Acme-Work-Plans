package acme.features.administrator.variables.percents;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.variables.Percent;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorPercentListService implements AbstractListService<Administrator, Percent> {
	
	@Autowired
	protected AdministratorPercentRepository repository;

	@Override
	public boolean authorise(final Request<Percent> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Percent> request, final Percent entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "data");
	}

	@Override
	public Collection<Percent> findMany(final Request<Percent> request) {
		assert request != null;
		
		return this.repository.findAllPercents();
	}

}
