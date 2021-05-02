package acme.features.anonymous.shout;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.features.generic.spam.GenericSpamService;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout>{

	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Autowired
	protected GenericSpamService spamService;
	
	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request!= null;
		
		return true;
	}

	@Override
	public void bind(final Request<Shout> request,final Shout entity,final Errors errors) {
		assert request!= null;
		assert entity!= null;
		assert errors!= null;
		
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Shout> request,final Shout entity,final Model model) {
		assert request!= null;
		assert entity!= null;
		assert model!= null;
		
		request.unbind(entity, model, "author", "text", "info");
		
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request!= null;
		Shout result;
		Date moment;
		
		moment= new Date(System.currentTimeMillis()-1);
		result= new Shout();
		result.setAuthor("John Doe");
		result.setText("Lorem ipsum!");
		result.setMoment(moment);
		result.setInfo("http://example.org");
		
		
		return result;
	}

	@Override
	public void validate(final Request<Shout> request,final Shout entity,final Errors errors) {
		assert request!= null;
		assert entity!= null;
		assert errors!= null;
		
		if (!errors.hasErrors("author")) {
			String text;
			
			text = entity.getAuthor().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "author", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("text")) {
			String text;
			
			text = entity.getText().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "text", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("info")) {
			String text;
			
			text = entity.getInfo().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "info", "anonymous.shout.form.error.spam");
		}
	}

	@Override
	public void create(final Request<Shout> request,final Shout entity) {
		assert request!= null;
		assert entity!= null;
		
		Date moment;
		
		moment= new Date(System.currentTimeMillis()-1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}

}
