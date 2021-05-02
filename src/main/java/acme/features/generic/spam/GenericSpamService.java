package acme.features.generic.spam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acme.entities.spam.SpamWord;
import acme.entities.variables.Percent;

@Service
public class GenericSpamService {
	
	@Autowired
	protected GenericSpamRepository repository;
	
	@Transactional(readOnly = true)
	public boolean isSpam(String text) {
		
		final List<SpamWord> spamWords = this.repository.findAllSpamWords();
		
		final Percent percent = this.repository.findPercentByCode("SPAM_THRESHOLD");
		
		final double caracteresTotales = text.length();
		
		if(percent == null || percent.getData().equals(0.)) {
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
		
		return (caracteresSpam/caracteresTotales)*100 >= percent.getData();
	}

}
