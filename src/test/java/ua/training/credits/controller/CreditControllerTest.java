package ua.training.credits.controller;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import ua.training.credits.entity.Credit;

public class CreditControllerTest {

	@Test
	public void testGetCreditsTermsByCriteria() {
		CreditController creditTermsController = new CreditController(null);
		
		Credit expected;
		
		List<Credit> credits = new ArrayList<>();
		credits.add(new Credit(null, Credit.Purpose.CONSUMER, null, 36, null));
		credits.add(new Credit(null, Credit.Purpose.MORTGAGE, null, 120, null));
		credits.add(expected = new Credit(null, Credit.Purpose.MORTGAGE, null, 36, null));
		
		assertSame(expected, creditTermsController.getCreditsTermsByCriteria(credits, Credit.Purpose.MORTGAGE, 36).get(0));
	}
	
	@Test(expected = Test.None.class)
	public void testGetCreditsTermsByCriteriaForNPE() {
		CreditController creditTermsController = new CreditController(null);

		creditTermsController.getCreditsTermsByCriteria(null, null, 0);
	}

}
