package com.breno.financecontrol.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	
	boolean existsByCategoryId(Long id);
}
