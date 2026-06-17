package com.breno.financecontrol.category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.financecontrol.exception.BusinessException;
import com.breno.financecontrol.exception.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Category insert(Category category) {
		Optional<Category> obj = categoryRepository.findByName(category.getName());
		
		if (obj.isPresent()) {
			throw new BusinessException("Category already exists");
		} 
			
		return categoryRepository.save(category);
	}
}
