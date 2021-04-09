package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.StudyApplicationTests;
import com.example.demo.model.Category;




public class CategoryRepositoryTest extends StudyApplicationTests{

	@Autowired
	private CategoryRepository cateRe;
	
	//@Test
	public void create() {
		String type = "COMPUTER";
		String title = "컴퓨터";
		LocalDateTime createdAt = LocalDateTime.now();
		String createdBy = "AdminServer";
		
		Category category = new Category();
		category.setType(type);
		category.setTitle(title); 
		category.setCreatedAt(createdAt); 
		category.setCreatedBy(createdBy);
		
		System.out.println("category:"+category);
		
		Category cat = cateRe.saveAndFlush(category); 
	
		Assert.assertNotNull(cat);
		Assert.assertEquals(cat.getType(), type);
		Assert.assertEquals(cat.getTitle(), title);
		
	} 
	
	@Test
	public void read() {
		Optional<Category> optionCategory = cateRe.findByType("COMPUTER");
		
		optionCategory.ifPresent(c -> {
			
			
			System.out.println(c.getId());
			System.out.println(c.getType());
			System.out.println(c.getTitle());
			
		});
		
		
	}
}
