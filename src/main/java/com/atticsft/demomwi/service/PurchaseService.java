/**
 * PurchaseService -- service to purchase a selected item
 * 
 * The purchaseItem of PurchaseService will default to a existing item
 * because there is no User Interface form for selecting an item.
 */
package com.atticsft.demomwi.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.model.Purchased;
import com.atticsft.demomwi.repository.ItemRepository;
import com.atticsft.demomwi.repository.PurchaseRepository;

/**
 * @author michaelbedry
 *
 */
@Service
public class PurchaseService {

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	PurchaseRepository purchaseRepository;

	/**
	 * purchaseItem -- adds the new item to the purchased table
	 * @param priceUpdated
	 * @return
	 */
	public Purchased purchaseItem(Boolean priceUpdated) {

		Item initialItem = itemRepository.findByName("ITEM4");
		Purchased purchased = new Purchased(initialItem.getId(), LocalDateTime.now(), initialItem.getPrice(), priceUpdated);
		return purchaseRepository.save(purchased);
	}

	/**
	 * getPurchaseCount -- return the number of items purchased
	 * @param savedItem
	 * @return
	 */
	public Long getPurchasedCount(Purchased savedItem) {
		Long itemCount = purchaseRepository.countByItemId(savedItem.getItemId());
		System.out.println("Purchased Items: " + itemCount);

		return itemCount;
	}
	
	/**
	 * uupdateItem -- updates the item table with the new price
	 * @param savedItem
	 */
	public void updateItem(Purchased savedItem) {
		LocalDateTime purchasedTime = savedItem.getDatePurchased();
		Duration duration = Duration.between(LocalDateTime.now(), purchasedTime);
		if (duration.getSeconds() <= 3600) {
			// retrieve item record from db
			Optional<Item> itemFound = itemRepository.findById(savedItem.getItemId());
			if (itemFound.isPresent()) {
				// update selected item price by !0%
				Item item = itemFound.get();
				item.setPrice(item.getPrice() * 1.1);
				itemRepository.save(item);
				savedItem.setPriceUpdated(Boolean.TRUE);
			}
		}
	}
	
	/**
	 * getAllPurchases -- return a list of all purchased items
	 * @return
	 */
	public List<Purchased> getAllPurchases() {
		Iterable<Purchased> itemiterable = purchaseRepository.findAll();
		List<Purchased> purchaseList = new ArrayList<>();
		itemiterable.forEach(a -> purchaseList.add(a));
		return purchaseList;
	}
}
