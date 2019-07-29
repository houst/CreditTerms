package ua.training.credits.entity;

import ua.training.credits.model.Bank;

public enum Banks {
	
	BIS(new Bank("Банк інвестицій та заощаджень")),
	KREDO(new Bank("Кредобанк"));
	
	private Bank bank;
	
	private Banks(Bank bank) {
		this.bank = bank;
	}
	
	public Bank getBank() {
		return bank;
	}
	
}
