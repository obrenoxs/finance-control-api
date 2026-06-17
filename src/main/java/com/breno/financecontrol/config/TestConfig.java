package com.breno.financecontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.breno.financecontrol.category.Category;
import com.breno.financecontrol.category.CategoryRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Category c1 = new Category(null, "Food");
		
		categoryRepository.save(c1);
		
	}
}
