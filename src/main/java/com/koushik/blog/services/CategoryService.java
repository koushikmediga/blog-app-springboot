package com.koushik.blog.services;

import java.util.List;


import com.koushik.blog.payloads.CategoryDto;

public interface CategoryService {

	//as methods in service interface are public and final by default no need to explicity mention them
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	 void deleteCategory(Integer categoryId);
	
	//get
	 CategoryDto getCategory(Integer categoryId);
	
	//get All
	 List<CategoryDto> getCategories();
}
