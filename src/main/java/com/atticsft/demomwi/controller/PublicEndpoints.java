/**
 * PublicEndpoints -- rest apis for non-authenticated resources
 */
package com.atticsft.demomwi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atticsft.demomwi.exception.NoSuchItemException;
import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.repository.ItemRepository;

/**
 * @author michaelbedry
 *
 */
@RestController
@RequestMapping()
public class PublicEndpoints {
	
	@Autowired
	private ItemRepository repo;

	@GetMapping("/items")
	public List<Item> getAllItems() {
		Iterable<Item> itemIterable = repo.findAll();
		List<Item> itemList = new ArrayList<>();
		itemIterable.forEach(a -> itemList.add(a));
		return itemList;
	}
	
	@GetMapping("/items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId) throws NoSuchItemException {
		Item item = repo.findById(itemId).orElseThrow(() -> new NoSuchItemException("Item not found!"));
		
		return ResponseEntity.ok(item);
	}	
}