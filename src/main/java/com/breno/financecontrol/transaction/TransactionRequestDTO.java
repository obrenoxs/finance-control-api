package com.breno.financecontrol.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionRequestDTO {

	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private TransactionType type;
	private Long categoryId;
	
	public TransactionRequestDTO() {
	}

	public TransactionRequestDTO(String description, BigDecimal amount, LocalDate date, TransactionType type,
			Long categoryId) {
		super();
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.type = type;
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
}
