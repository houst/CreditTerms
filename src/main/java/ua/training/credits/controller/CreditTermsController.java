package ua.training.credits.controller;

import java.util.ArrayList;
import java.util.List;

import ua.training.credits.entity.Credits;
import ua.training.credits.model.CreditTerms;
import ua.training.credits.view.ConsoleView;
import ua.training.credits.view.TextConstant;

public class CreditTermsController {
	
	private ConsoleView consoleView;
	
	public CreditTermsController(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}
	
	/**
	 * Get all credits from enumerator
	 * @return
	 */
	public List<CreditTerms> getAllCreditsTerms() {
		List<CreditTerms> creditsTerms = new ArrayList<>();
		
		for (Credits c : Credits.values()) {
			creditsTerms.add(c.getCreditTerms());
		}
		
		return creditsTerms;
	}
	
	/**
	 * TODO: Hardcode
	 * @param credits
	 * @return
	 */
	public List<CreditTerms> getCreditsTermsByPurposeAndTerm(List<CreditTerms> credits) {
		CreditTerms.Purpose purposeCriteria = inputCreditPurposeWithScanner();
		int termCriteria = inputCreditTermWithScanner(credits);
		
		return getCreditsTermsByCriteria(credits, purposeCriteria, termCriteria);
	}
	
	/**
	 * This method takes criteria from user and return list of credits which matches with criteria
	 * @param credits
	 * @param purposeCriteria
	 * @param termCriteria
	 * @return
	 */
	public List<CreditTerms> getCreditsTermsByCriteria(List<CreditTerms> credits, 
			CreditTerms.Purpose purposeCriteria,
			int termCriteria) {
		
		List<CreditTerms> res = new ArrayList<>();
		
		if (credits == null) {
			return res;
		}
		
		for (CreditTerms credit : credits) {
			if (credit.getPurpose().equals(purposeCriteria) && 
					credit.getTermInMonths() == termCriteria) {
				res.add(credit);
			}
		}
		
		return res;
	}
	
	/**
	 * This method gives user information about credit purposes and then gets his choice
	 * @return
	 */
	private CreditTerms.Purpose inputCreditPurposeWithScanner() {
		
		CreditTerms.Purpose[] purposes = CreditTerms.Purpose.values();
		
		for (int i = 0; i < purposes.length; i++) {
			consoleView.printMessage(i + " - " + purposes[i]);
		}
		
		int purposeId = new UtillityController(consoleView)
				.inputIntValueWithScannerInDiapason(TextConstant.CREDIT_PURPOSE, 0, purposes.length - 1);
		
		return purposes[purposeId];
		
	}
	
	/**
	 * This method gives user information about credit terms in mouths and then gets his choice
	 * @return
	 */
	private int inputCreditTermWithScanner(List<CreditTerms> credits) {
		
		List<Integer> terms = new ArrayList<>();
		
		for (CreditTerms credit : credits) {
			int term = credit.getTermInMonths();
			
			if (!terms.contains(term)) {
				terms.add(term);
			}
		}
		
		for (int i = 0; i < terms.size(); i++) {
			consoleView.printMessage(i + " - " + terms.get(i));
		}
		
		int term = new UtillityController(consoleView)
				.inputIntValueWithScannerInDiapason(TextConstant.CREDIT_TERM_IN_MONTHS, 0, terms.size() - 1);
		
		return terms.get(term);
		
	}
	
}
