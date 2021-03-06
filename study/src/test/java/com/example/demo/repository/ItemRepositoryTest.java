package com.example.demo.repository;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.Item;



public class ItemRepositoryTest extends StudyApplicationTests{

	@Autowired
	private ItemRepository itemRepsotory;
	
	@Test
	public void create() {
		Item item = new Item();
		item.setStatus("UNREGISTERED");
		item.setName("삼성 노트북");
		item.setTitle("삼성 노트북 A100");
		item.setContent("2019년형 노트북 입니다.");
		//item.setPrice(90000);
		item.setBrandName("삼성");
		item.setRegisteredAt(LocalDateTime.now());
		item.setCreatedAt(LocalDateTime.now());
		item.setCreatedBy("Partner01");
		//item.setPartnerId(1L); long ->partner
		/*
		Item item = new Item();
		item.setName("노트북"); 
		item.setPrice(100000);
		item.setContent("삼성 노트북");
		*/
		Item newItem = itemRepsotory.save(item);
		Assert.assertNotNull(newItem);
	}
	
	@Test
	public void read() {
		Long id = 1L;
		
		java.util.Optional<Item> item = itemRepsotory.findById(id);
		
		Assert.assertTrue(item.isPresent());
		
		
	}
}
