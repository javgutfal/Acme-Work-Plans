package acme.features.anonymous.shout;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.entities.spam.SpamWord;
import acme.entities.variables.Percent;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout>{

	@Autowired
	protected AnonymousShoutRepository repository;
	
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
		
		List<SpamWord> spamWords;
		Percent percent;
		
		spamWords = this.repository.findAllSpamWords();
		percent = this.repository.findPercentByCode("SPAM_THRESHOLD");
		
		if (!errors.hasErrors("author")) {
			String text;
			
			text = entity.getAuthor().toLowerCase();
			errors.state(request, !this.isSpam(spamWords, text, (percent != null)?percent.getData():0.0), "author", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("info")) {
			String text;
			
			text = entity.getAuthor().toLowerCase();
			errors.state(request, !this.isSpam(spamWords, text, (percent != null)?percent.getData():0), "info", "anonymous.shout.form.error.spam");
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
	
	
	// PRIVATE METHODS
	
	/**
	 * Function which detects text with spam
	 * 
	 * @param spamWords
	 * @param text
	 * @param percent
	 * @return
	 */
	private boolean isSpam(final List<SpamWord> spamWords, String text, final Double percent) {
		final double caracteresTotales = text.length();
		
		if(percent.equals(0.)) {
			return false;
		}
		
		for(final SpamWord spamWord : spamWords) {
			if(text.contains(spamWord.getWordEs())) {
				text = text.replace(spamWord.getWordEs(), "");
			}
			if(text.contains(spamWord.getWordEn())) {
				text = text.replace(spamWord.getWordEn(), "");
			}
		}
		
		final double caracteresSpam = caracteresTotales - text.length();
		
		return (caracteresSpam/caracteresTotales)*100 >= percent;
	}

}
