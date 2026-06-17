package com.breno.financecontrol.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.financecontrol.exception.BusinessException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category insert(Category category) {
		Optional<Category> obj = categoryRepository.findByName(category.getName());
		
		if (!obj.isPresent()) {
			return categoryRepository.save(category);
		} else {
			throw new BusinessException("Category already exists");
		}
	}
}
