package com.breno.financecontrol.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
	
	public TransactionResponseDTO create(TransactionRequestDTO dto) {
		Transaction entity = new Transaction();
		
		copyDtoToEntity(entity, dto);
		
		Category category = validateAndGetCategory(dto.getCategoryId());
		
		entity.setCategory(category);
		
		validateTransaction(entity);
		
		entity = transactionRepository.save(entity);
		
		TransactionResponseDTO obj = new TransactionResponseDTO(entity);
		
		return obj;
	}
	
	public TransactionResponseDTO update(Long id, TransactionRequestDTO dto) {
		Transaction entity = findById(id);
		
		Category category = validateAndGetCategory(dto.getCategoryId());
	
		copyDtoToEntity(entity, dto);
		
		entity.setCategory(category);
		
		validateTransaction(entity);
		
		entity = transactionRepository.save(entity);
		
		TransactionResponseDTO obj = new TransactionResponseDTO(entity);
		
		return obj;
	}
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	public List<TransactionResponseDTO> findAllResponse(){
		List<Transaction> list = findAll();
		
		return list.stream()
				.map(TransactionResponseDTO::new)
				.toList();
	}
	
	public Transaction findById(Long id) {
		    return transactionRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public TransactionResponseDTO findByIdResponse(Long id) {
		Transaction obj = findById(id);
		
		return new TransactionResponseDTO(obj);
	}
	
	public BalanceDTO getBalance() {
		List<Transaction> list = transactionRepository.findAll();
		
		BigDecimal income = BigDecimal.ZERO;
		BigDecimal expense = BigDecimal.ZERO;
		
		for (Transaction transaction : list) {
			if (transaction.getType() == TransactionType.INCOME) {
				income = income.add(transaction.getAmount());
			} else if (transaction.getType() == TransactionType.EXPENSE){
				expense = expense.add(transaction.getAmount());
			}
		}
		
		BigDecimal balance = income.subtract(expense);
		
		return new BalanceDTO(income, expense, balance);
	}
	
	public void delete(Long id) {
		if (!transactionRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		
		transactionRepository.deleteById(id);
	}
	
	private void copyDtoToEntity(Transaction entity, TransactionRequestDTO dto) {
		entity.setDescription(dto.getDescription());
		entity.setAmount(dto.getAmount());
		entity.setDate(dto.getDate());
		entity.setType(dto.getType());
	}
	
	private Category validateAndGetCategory(Long categoryId) {
		if (categoryId == null) {
		    throw new BusinessException("Transaction category is required");
		}
		
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException(categoryId));
	}
	
	private void validateTransaction(Transaction obj) {
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
	}
}
