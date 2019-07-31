package ua.training.credits.controller;

import java.util.List;

import ua.training.credits.entity.Credit;
import ua.training.credits.view.ConsoleView;
import ua.training.credits.view.TextConstant;

public class MainController {
	
	private ConsoleView consoleView;
	
	public MainController(ConsoleView consoleView) {
		this.consoleView = consoleView;
	}
	
	public void process() {
		CreditController creditTermsController = new CreditController(consoleView);
		List<Credit> credits = creditTermsController.getAllCreditsTerms();
		
		UtillityController utillityController = new UtillityController(consoleView);
		
		// Menu option
		consoleView.showMenu();
		int chosen = utillityController.inputIntValueWithScannerInDiapason(TextConstant.MENU_OPTION, 1, 3);
		
		// All credits
		if (chosen == 1) {
			for (Credit credit : credits) {
				consoleView.printCreditTerms(credit);
			}
		}
		
		// Credits by criteria
		if (chosen == 2) {
			for (Credit credit : creditTermsController.getCreditsTermsByPurposeAndTerm(credits)) {
				consoleView.printCreditTerms(credit);
			}
		}
		
		// Exit
		if (chosen == 3) {
			consoleView.printGoodBye();
		}
	}
	
}
