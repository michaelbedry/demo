package com.atticsft.demomwi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.repository.ItemRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ItemsTest {

	@Autowired
	private ItemRepository repo;
		

	@Test
	public void testFindAll() {
		List<Item> items = repo.findAll();		
		assertThat(items.size()).isGreaterThan(0);
	}
	
	@Test
	public void testFindItemByName() {
		String name = "ITEM3";
		Item item = repo.findByName(name);
		assertThat(item.getName()).isEqualTo(name);
	}

	@Test
	public void testFindItemById() {
		Long id = 3L;
		Optional<Item> itemSearch = repo.findById(id);
		Item item = null;
		if (itemSearch.isPresent()) {
			item = itemSearch.get();
			System.out.println("TIEM name " + item.getName());
			assertThat(item.getName()).isEqualTo("ITEM3");
		} else {
			assertNull(item);
		}		
	}

	@Test
	public void testFindItemByIdNotFound() {				
		Long id = 7L;
		Optional<Item> itemSearch = repo.findById(id);
		Item item = null;
		if (itemSearch.isPresent()) {
			item = itemSearch.get();
			System.out.println("TIEM name " + item.getName());
			assertThat(item.getName()).isEqualTo("ITEM3");
		} else {
			assertNull(item);
		}		
	}

	@Test
	public void testFindAllItems() {		
		List<Item> items = repo.findAll();
				
		assertEquals(items.size(),5);
		
	}
		
}
