package com.example.demo.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.StudyApplicationTests;
import com.example.demo.model.Item;
import com.sun.el.stream.Optional;

import junit.framework.Assert;

public class ItemRepositoryTest extends StudyApplicationTests{

	@Autowired
	private ItemRepository itemRepsotory;
	
	@Test
	public void create() {
		
		Item item = new Item();
		item.setName("≥Î∆Æ∫œ");
		item.setPrice(100000);
		item.setContent("ªÔº∫ ≥Î∆Æ∫œ");
		
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
