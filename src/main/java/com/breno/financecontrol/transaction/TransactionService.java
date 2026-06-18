package com.breno.financecontrol.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.financecontrol.category.Category;
import com.breno.financecontrol.category.CategoryRepository;
import com.breno.financecontrol.exception.BusinessException;
import com.breno.financecontrol.exception.ResourceNotFoundException;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Transaction create(Transaction obj) {
		Category category = categoryRepository.findById(obj.getCategory().getId())
				.orElseThrow(() -> new ResourceNotFoundException(obj.getCategory().getId()));
		
		obj.setCategory(category);
		
		if (obj.getAmount() == null) {
			throw new BusinessException("Transaction amount is required");
		}
		
		if (obj.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
			throw new BusinessException("Amount must be greater than zero");
		}
		
		if (obj.getDate() == null) {
			throw new BusinessException("Transaction date is required");
		}
		
		if (obj.getDate().isAfter(LocalDate.now())) {
			throw new BusinessException("Transaction date cannot be in the future");
		}
		
		if (obj.getType() == null) {
			throw new BusinessException("Transaction type is required");
		}
		
		return transactionRepository.save(obj);
	}
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	public Transaction findById(Long id) {
		Optional<Transaction> obj = transactionRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete(Long id) {
		if (!transactionRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		
		transactionRepository.deleteById(id);
	}
}
