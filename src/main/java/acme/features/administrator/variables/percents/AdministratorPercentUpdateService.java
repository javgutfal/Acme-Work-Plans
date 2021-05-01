package acme.features.administrator.variables.percents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.variables.Percent;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorPercentUpdateService implements AbstractUpdateService<Administrator, Percent> {

	@Autowired
	protected AdministratorPercentRepository repository;

	@Override
	public boolean authorise(final Request<Percent> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void bind(final Request<Percent> request, final Percent entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Percent> request, final Percent entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "code", "data");
	}

	@Override
	public Percent findOne(final Request<Percent> request) {
		assert request != null;
		
		Percent result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		
		return result;
	}

	@Override
	public void validate(final Request<Percent> request, final Percent entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Percent> request, final Percent entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
