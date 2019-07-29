package ua.training.credits.entity;

import java.math.BigDecimal;

import ua.training.credits.model.CreditTerms;

public enum Credits {
	
	BIS_MORTGAGE_1(
			new CreditTerms(
					Banks.BIS.getBank(),
					CreditTerms.Purpose.MORTGAGE,
					new BigDecimal("37.7"),
					36,
					new BigDecimal("5000000"),
					true, 
					false)
			),
	BIS_MORTGAGE_2(
			new CreditTerms(
					Banks.BIS.getBank(),
					CreditTerms.Purpose.MORTGAGE,
					new BigDecimal("36.14"),
					120,
					new BigDecimal("5000000"),
					true, 
					true)
			),
	KREDO_MORTGAGE_1(
			new CreditTerms(
					Banks.KREDO.getBank(),
					CreditTerms.Purpose.MORTGAGE,
					new BigDecimal("21.68"),
					36,
					new BigDecimal("3000000"),
					true, 
					false)
			);
	
	private CreditTerms creditTerms;
	
	private Credits(CreditTerms creditTerms) {
		creditTerms.getBank().addCreditTerms(creditTerms);
		this.creditTerms = creditTerms;
	}

	public CreditTerms getCreditTerms() {
		return creditTerms;
	}
	
}
