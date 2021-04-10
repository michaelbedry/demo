/**
 * PurchasedItemsTest -- test class to verify logic for adding purchased items
 */
package com.atticsft.demomwi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.atticsft.demomwi.model.Item;
import com.atticsft.demomwi.model.Purchased;
import com.atticsft.demomwi.repository.ItemRepository;
import com.atticsft.demomwi.repository.PurchaseRepository;
import com.atticsft.demomwi.service.PurchaseService;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

/**
 * @author michaelbedry
 *
 */

@SpringBootTest
public class PurchasedItemsTest {

	@Autowired
	private ItemRepository repo;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Autowired
	private PurchaseService service;

	@Test
	public void testCreatePurchaseItem() {

		Purchased itemToBePurchased = new Purchased(1L, LocalDateTime.now(), 23.34, Boolean.FALSE);
		Purchased savedItem = purchaseRepository.save(itemToBePurchased);

		System.out.println("SAVED ITEM " + savedItem.toString());
		System.out.println("COUNT " + purchaseRepository.count());

		assertThat(savedItem.getId()).isNotNull();
	}

	@Test
	public void testPurchaseItem() {
//		Item item = repo.findByName("ITEM3");
//		Purchased itemToBePurchased = new Purchased(item.getId(), LocalDateTime.now(), item.getPrice());
		Purchased savedPurchasedItem = service.purchaseItem(Boolean.FALSE);

		assertThat(savedPurchasedItem.getId()).isNotNull();
		assertThat(savedPurchasedItem.getPrice()).isEqualTo(25.916);

	}

	@Test
	public void testPurchase11Items() {
		Purchased savedItem = null;
		Item updatedItem = null;
		try {
			for (int i = 1; i < 11; i++) {
				savedItem = service.purchaseItem(Boolean.FALSE);
				
				// pause for 2 sec
				Thread.sleep(2000);
			}

			// create 11th purchased item record
			savedItem = service.purchaseItem(Boolean.FALSE);
			service.updateItem(savedItem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		updatedItem = repo.findByName("ITEM4");

		assertThat(purchaseRepository.count()).isEqualTo(12);
		assertThat(savedItem.getId()).isNotNull();
		assertThat(updatedItem.getPrice()).isEqualTo(25.916);

	}

}
