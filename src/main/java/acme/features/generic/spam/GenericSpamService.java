package acme.features.generic.spam;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.entities.spam.SpamWord;
import acme.entities.variables.Percent;

@Service
public class GenericSpamService {
	
	@Autowired
	protected GenericSpamRepository repository;
	
	private List<SpamWord> spamWords;
	
	private Percent percent;
	
	@PostConstruct
	public void initialise() {
		this.spamWords = this.repository.findAllSpamWords();
		this.percent = this.repository.findPercentByCode("SPAM_THRESHOLD");
	}
	
	@Transactional(readOnly = true)
	public boolean isSpam(String text) {
		final double caracteresTotales = text.length();
		
		if(this.percent == null || this.percent.getData().equals(0.)) {
			return false;
		}
		
		for(final SpamWord spamWord : this.spamWords) {
			if(text.contains(spamWord.getWordEs())) {
				text = text.replace(spamWord.getWordEs(), "");
			}
			if(text.contains(spamWord.getWordEn())) {
				text = text.replace(spamWord.getWordEn(), "");
			}
		}
		
		final double caracteresSpam = caracteresTotales - text.length();
		
		return (caracteresSpam/caracteresTotales)*100 >= this.percent.getData();
	}

}
