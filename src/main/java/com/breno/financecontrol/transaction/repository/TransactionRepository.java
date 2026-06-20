package com.breno.financecontrol.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.breno.financecontrol.transaction.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	boolean existsByCategoryId(Long id);
}
