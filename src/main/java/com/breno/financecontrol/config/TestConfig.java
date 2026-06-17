package com.breno.financecontrol.config;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.breno.financecontrol.category.Category;
import com.breno.financecontrol.category.CategoryRepository;
import com.breno.financecontrol.transaction.Transaction;
import com.breno.financecontrol.transaction.TransactionRepository;
import com.breno.financecontrol.transaction.TransactionType;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Food");
		
		categoryRepository.save(c1);
		
		Transaction tx1 = new Transaction(null, "Supermarket", new BigDecimal("150.00"), LocalDate.now(), TransactionType.EXPENSE, c1);
		
		transactionRepository.save(tx1);
	}
}
