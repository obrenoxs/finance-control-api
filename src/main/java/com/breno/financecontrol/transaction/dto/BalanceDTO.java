package com.breno.financecontrol.transaction.dto;

import java.math.BigDecimal;

public class BalanceDTO {

	private BigDecimal income;
	private BigDecimal expense;
	private BigDecimal balance;
	
	public BalanceDTO(){
	}

	public BalanceDTO(BigDecimal income, BigDecimal expense, BigDecimal balance) {
		super();
		this.income = income;
		this.expense = expense;
		this.balance = balance;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public BigDecimal getExpense() {
		return expense;
	}

	public BigDecimal getBalance() {
		return balance;
	}
}
