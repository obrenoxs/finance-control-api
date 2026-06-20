package com.breno.financecontrol.category.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.breno.financecontrol.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Optional<Category> findByName(String name);
}
