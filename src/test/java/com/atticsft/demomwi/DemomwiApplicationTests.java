/**
 * DemomwiApplicationTests - test class to verify that spring configuration is loaded
 */
package com.atticsft.demomwi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.repository.ItemRepository;

/**
 * @author michaelbedry
 *
 */
@SpringBootTest
class DemomwiApplicationTests {
	
	@Autowired
	ItemRepository repo;

	@Test
	void contextLoads() {
		
		List<Item> list = repo.findAll();
		
		System.out.println("item count: " + list.size());
		assert(list.size() > 0);
	}

}
