package com.breno.financecontrol.category.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.financecontrol.category.dto.CategoryRequestDTO;
import com.breno.financecontrol.category.dto.CategoryResponseDTO;
import com.breno.financecontrol.category.entity.Category;
import com.breno.financecontrol.category.repository.CategoryRepository;
import com.breno.financecontrol.exception.BusinessException;
import com.breno.financecontrol.exception.ResourceNotFoundException;
import com.breno.financecontrol.transaction.repository.TransactionRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public List<CategoryResponseDTO> findAllResponse(){
		List<Category> list = findAll();
		
		return list.stream()
				.map(CategoryResponseDTO::new)
				.toList();
	}
	
	public Category findById(Long id) {
		return categoryRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public CategoryResponseDTO findByIdResponse(Long id) {
		Category obj = findById(id);
		
		return new CategoryResponseDTO(obj);
	}
	
	public Category create(CategoryRequestDTO dto) {
		Optional<Category> obj = categoryRepository.findByName(dto.getName());
		
		if (obj.isPresent()) {
			throw new BusinessException("Category already exists");
		} 
		
		Category entity = new Category(null, dto.getName());
		
		return categoryRepository.save(entity);
	}
	
	public void delete(Long id) {
		if (!categoryRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		
		if (transactionRepository.existsByCategoryId(id)) {
			throw new BusinessException("Category cannot be deleted because it has transactions");
		}
		
		categoryRepository.deleteById(id);
	}
	
	public Category update(Long id, CategoryRequestDTO dto) {
		Category entity = findById(id);
		
		Optional<Category> categoryFound = categoryRepository.findByName(dto.getName());
		
		if (categoryFound.isPresent()) {
			
			Category categoryFoundEntity = categoryFound.get();
			
			if (!categoryFoundEntity.getId().equals(entity.getId())) {
				throw new BusinessException("Category already exists");
			}
		}
		
		copyDtoToEntity(entity, dto);
		
		return categoryRepository.save(entity);
	}
	
	private void copyDtoToEntity(Category entity, CategoryRequestDTO dto) {
		entity.setName(dto.getName());
	}
}