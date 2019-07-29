package ua.training.credits.controller;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ua.training.credits.model.CreditTerms;

public class CreditTermsControllerTest {

	@Test
	public void testGetCreditsTermsByCriteria() {
		CreditTermsController creditTermsController = new CreditTermsController(null);
		
		CreditTerms expected;
		
		List<CreditTerms> credits = new ArrayList<>();
		credits.add(new CreditTerms(null, CreditTerms.Purpose.CONSUMER, null, 36, null, false, false));
		credits.add(new CreditTerms(null, CreditTerms.Purpose.MORTGAGE, null, 120, null, false, false));
		credits.add(expected = new CreditTerms(null, CreditTerms.Purpose.MORTGAGE, null, 36, null, false, false));
		
		assertSame(expected, creditTermsController.getCreditsTermsByCriteria(credits, CreditTerms.Purpose.MORTGAGE, 36).get(0));
	}
	
	@Test(expected = Test.None.class)
	public void testGetCreditsTermsByCriteriaForNPE() {
		CreditTermsController creditTermsController = new CreditTermsController(null);

		creditTermsController.getCreditsTermsByCriteria(null, null, 0);
	}

}
