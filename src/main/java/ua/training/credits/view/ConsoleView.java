package ua.training.credits.view;

import static ua.training.credits.view.TextConstant.*;

import java.util.Locale;
import java.util.ResourceBundle;

import ua.training.credits.model.CreditTerms;

public class ConsoleView {
	
	private static final String MESSAGES = "messages";
	
	public static final ResourceBundle bundle = 
			ResourceBundle.getBundle(
					MESSAGES,
//					new Locale("ua", "UA"));
					new Locale("en"));
	
	public void printMessage(String message) {
		System.out.println(message);
	}
	
	public void printGoodBye() {
		printMessage(bundle.getString(GOODBYE));
	}
	
	public void printStringInput(String fieldName, String regex) {
        printMessage(concatenateStrings(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(fieldName),
                bundle.getString(REGEX),
                regex,
                bundle.getString(COLON)));
    }
	
	public void printWrongStringInput(String fieldName, String regex) {
        printMessage(concatenateStrings(
        		bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(fieldName),
                bundle.getString(REGEX),
                regex,
                bundle.getString(COLON)));
    }
	
	public void printCreditTerms(CreditTerms credit) {
		printMessage(concatenateStrings(
				bundle.getString(CREDIT_BANK_NAME), bundle.getString(COLON), credit.getBank().getName(), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_PURPOSE), bundle.getString(COLON), credit.getPurpose().toString(), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_RATE), bundle.getString(COLON), credit.getRate().toString(), bundle.getString(PERCENT), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_TERM_IN_MONTHS), bundle.getString(COLON), Integer.toString(credit.getTermInMonths()), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_MAXSUM), bundle.getString(COLON), credit.getMaxSum().toString(), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_ISEARLYREPAYABLE), bundle.getString(COLON), 
				credit.isEarlyRepayable() ? bundle.getString(OUTPUT_YES) : bundle.getString(OUTPUT_NO), 
				bundle.getString(SEPARATOR),
				bundle.getString(CREDIT_ISCREDITLINEINCREASABLE), bundle.getString(COLON), 
				credit.isCreditLineIncreasable() ? bundle.getString(OUTPUT_YES) : bundle.getString(OUTPUT_NO)));
	}
	
	public void showMenu() {
		printMessage(bundle.getString(MENU));
		printMessage(bundle.getString(MENU_OPTION_ALL_CREDITS));
		printMessage(bundle.getString(MENU_OPTION_SEARCH));
		printMessage(bundle.getString(MENU_OPTION_EXIT));
	}
	
	private String concatenateStrings(String...args) {
		StringBuilder concatStr = new StringBuilder();
		for(String str : args) {
			concatStr.append(str);
		}
		return concatStr.toString();
	}
	
}
