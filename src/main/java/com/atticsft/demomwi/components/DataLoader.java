package com.atticsft.demomwi.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.repository.ItemRepository;

@Component
public class DataLoader implements ApplicationRunner {

	private ItemRepository repo;
	
	
	@Autowired
	public DataLoader(ItemRepository repo) {
		this.repo = repo;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (int i = 1; i < 6; i++) {
			Item item = new Item("ITEM"+i, "Test for Item"+i, 23.56);
			repo.save(item);
		}
	}
}
