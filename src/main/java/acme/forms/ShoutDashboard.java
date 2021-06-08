package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoutDashboard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Atributos
	

	Double averageOfShoutCurrencyEUR;
	Double averageOfShoutCurrencyUSD;
	Double deviationOfShoutCurrencyEUR;
	Double deviationOfShoutCurrencyUSD;
	Double ratioOfShoutsFlagged;
	Double ratioOfShoutsXXX;

}
