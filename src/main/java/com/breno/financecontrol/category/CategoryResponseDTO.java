package com.breno.financecontrol.category;

public class CategoryResponseDTO {

	private Long id;
	private String name;
	
	public CategoryResponseDTO() {
	}

	public CategoryResponseDTO(Category entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
