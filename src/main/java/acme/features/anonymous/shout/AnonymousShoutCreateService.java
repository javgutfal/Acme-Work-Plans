package acme.features.anonymous.shout;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.XXX.XXX;
import acme.entities.shouts.Shout;
import acme.features.anonymous.XXX.AnonymousXXXRepository;
import acme.features.generic.spam.GenericSpamService;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.datatypes.Money;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout>{

	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Autowired
	protected AnonymousXXXRepository xxxRepository;
	
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
		
		request.unbind(entity, model, "author", "text", "info", "xxx.xxx1", "xxx.money.amount", "xxx.money.currency", "xxx.flag");
		
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request!= null;
		Shout result;
		Date moment;
		final XXX xxx = new XXX();
		final Money money = new Money();
		
		moment= new Date(System.currentTimeMillis()-1);
		result= new Shout();
		
		xxx.setMoney(money);
		xxx.setMoment(moment);
		result.setXxx(xxx);
		result.setMoment(moment);		
		
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
		
		if (!errors.hasErrors("text")) {
			String text;
			
			text = entity.getText().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "text", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("xxx.money.currency")) {
			final String text;
			

			text = entity.getXxx().getMoney().getCurrency().toLowerCase();
			errors.state(request, !this.spamService.isSpam(text), "xxx.money.currency", "anonymous.shout.form.error.spam");
		}	
		
		if (!errors.hasErrors("xxx.money.currency")) {
			final String text;
			

			text = entity.getXxx().getMoney().getCurrency().toUpperCase();
			errors.state(request, text.equals("EUR") || text.equals("USD"), "xxx.money.currency", "anonymous.shout.form.error.XXX");
		}
		
		if (!errors.hasErrors("xxx.xxx1")) {
			final String text;
			

			text = entity.getXxx().getXxx1();
			errors.state(request, !this.spamService.isSpam(text), "xxx.money.currency", "anonymous.shout.form.error.spam");
		}
		
		if (!errors.hasErrors("xxx.xxx1")) {
			final String text;
			
			text = entity.getXxx().getXxx1();
			errors.state(request, text.matches("^((19|2[0-9])[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$"), "xxx.xxx1", "anonymous.shout.form.error.XXX.xxx1.pattern");
		}
		
		if (!errors.hasErrors("xxx.xxx1")) {
			final String text;
			
			final Date moment= new Date(System.currentTimeMillis()-1);
			final String[] m = moment.toInstant().toString().split("T")[0].split("-");
			
			text = entity.getXxx().getXxx1();
			errors.state(request, text.equals(m[0]+"/"+m[1]+"/"+m[2]), "xxx.xxx1", "anonymous.shout.form.error.XXX.xxx1.today");
		}
		
		if (!errors.hasErrors("xxx.xxx1")) {
			final String text;
			

			text = entity.getXxx().getXxx1();
			errors.state(request, this.xxxRepository.findOneByXXX1(text)==null, "xxx.xxx1", "anonymous.shout.form.error.XXX.xxx1.exists");
		}
	}

	@Override
	public void create(final Request<Shout> request,final Shout entity) {
		assert request!= null;
		assert entity!= null;
		
		Date moment;
		final Money m = new Money();
		final XXX xxx = new XXX();
		
		final String money = request.getServletRequest().getParameter("xxx.money.amount");
		final String currency = request.getServletRequest().getParameter("xxx.money.currency");
		final String flag = request.getServletRequest().getParameter("xxx.flag");
		final String xxx1 = request.getServletRequest().getParameter("xxx.xxx1");
		m.setAmount(Double.parseDouble(money));
		m.setCurrency(currency);
		
		moment= new Date(System.currentTimeMillis()-1);
		entity.setMoment(moment);
		xxx.setMoney(m);
		xxx.setFlag(Boolean.parseBoolean(flag));
		xxx.setMoment(moment);
		xxx.setXxx1(xxx1);
		this.xxxRepository.save(xxx);
		entity.setXxx(xxx);
		this.repository.save(entity);
	}

}
