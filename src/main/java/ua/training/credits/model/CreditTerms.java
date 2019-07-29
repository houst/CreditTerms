package ua.training.credits.model;

import java.math.BigDecimal;

/**
 * This type represents terms of purpose credits which issued by different banks.
 * @author oleglitvinenko
 *
 */
public class CreditTerms {
	
	private Bank bank;

	private Purpose purpose;
	
	private BigDecimal rate;
	
	private int termInMonths;
	
	private BigDecimal maxSum;
	
	private boolean isEarlyRepayable;
	
	private boolean isCreditLineIncreasable;
	
	public CreditTerms() {}
	
	public CreditTerms(Bank bank, 
			Purpose purpose, 
			BigDecimal rate, 
			int termInMonths, 
			BigDecimal maxSum, 
			boolean isEarlyRepayable, 
			boolean isCreditLineIncreasable) {
		this.bank = bank;
		this.purpose = purpose;
		this.rate = rate;
		this.termInMonths = termInMonths;
		this.maxSum = maxSum;
		this.isEarlyRepayable = isEarlyRepayable;
		this.isCreditLineIncreasable = isCreditLineIncreasable;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public int getTermInMonths() {
		return termInMonths;
	}

	public void setTermInMonths(int termInMonths) {
		this.termInMonths = termInMonths;
	}

	public BigDecimal getMaxSum() {
		return maxSum;
	}

	public void setMaxSum(BigDecimal maxSum) {
		this.maxSum = maxSum;
	}

	public boolean isEarlyRepayable() {
		return isEarlyRepayable;
	}

	public void setEarlyRepayable(boolean isEarlyRepayable) {
		this.isEarlyRepayable = isEarlyRepayable;
	}

	public boolean isCreditLineIncreasable() {
		return isCreditLineIncreasable;
	}

	public void setCreditLineIncreasable(boolean isCreditLineIncreasable) {
		this.isCreditLineIncreasable = isCreditLineIncreasable;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isCreditLineIncreasable ? 1231 : 1237);
		result = prime * result + (isEarlyRepayable ? 1231 : 1237);
		result = prime * result + ((maxSum == null) ? 0 : maxSum.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + termInMonths;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditTerms other = (CreditTerms) obj;
		if (isCreditLineIncreasable != other.isCreditLineIncreasable)
			return false;
		if (isEarlyRepayable != other.isEarlyRepayable)
			return false;
		if (maxSum == null) {
			if (other.maxSum != null)
				return false;
		} else if (!maxSum.equals(other.maxSum))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (purpose != other.purpose)
			return false;
		if (termInMonths != other.termInMonths)
			return false;
		return true;
	}

	public enum Purpose {
		
		MORTGAGE, CAR_LEASING, CONSUMER, BUSINESS
		
	}
	
}