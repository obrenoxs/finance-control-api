package com.breno.financecontrol.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.breno.financecontrol.transaction.entity.Transaction;
import com.breno.financecontrol.transaction.enums.TransactionType;

public class TransactionResponseDTO {

	private Long id;
	private String description;
	private BigDecimal amount;
	private LocalDate date;
	private TransactionType type;
	private String categoryName;
	
	public TransactionResponseDTO() {
	}

	public TransactionResponseDTO(Transaction entity) {
		super();
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.amount = entity.getAmount();
		this.date = entity.getDate();
		this.type = entity.getType();
		this.categoryName = entity.getCategory().getName();
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
