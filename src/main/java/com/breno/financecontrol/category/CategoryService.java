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
	
	public Category update(Long id, Category category) {
		Category entity = findById(id);
		
		Optional<Category> categoryFound = categoryRepository.findByName(category.getName());
		
		if (categoryFound.isPresent()) {
			
			Category categoryFoundEntity = categoryFound.get();
			
			if (!categoryFoundEntity.getId().equals(entity.getId())) {
				throw new BusinessException("Category already exists");
			}
		}
		
		updateData(entity, category);
		
		return categoryRepository.save(entity);
	}
	
	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
	}
}