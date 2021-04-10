/**
 * PrivateEndpoint -- rest api for authenticated resources
 */
package com.atticsft.demomwi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atticsft.demomwi.model.Purchased;
import com.atticsft.demomwi.service.PurchaseService;

/**
 * @author michaelbedry
 *
 */
@RestController
@RequestMapping("private")
public class PrivateEndpoint {
	
	@Autowired
	private PurchaseService purchaseService;
	
	Boolean isUpdated = Boolean.FALSE;
	Long purchaseCount = 0L;

	@GetMapping("/allPurchases")
	public List<Purchased> showAllPurchases(Model model) {
		Iterable<Purchased> purchaseIterable = purchaseService.getAllPurchases();
		List<Purchased> purchaseList = new ArrayList<>();
		purchaseIterable.forEach(a -> purchaseList.add(a));
		return purchaseList;
	}
	
	@PostMapping("/purchase")
	public ResponseEntity<Purchased> purchasedItem(Model model) {

		Purchased newPurchase = purchaseService.purchaseItem(isUpdated);
		Long purchaseCount = purchaseService.getPurchasedCount(newPurchase);
		
		// check to see if the number of items added with in an hour has been met and
		// the price has not already been updated
		if (purchaseCount > 9 && !isUpdated) {
			purchaseService.updateItem(newPurchase);
			if (newPurchase.isPriceUpdated()) {
				isUpdated = Boolean.TRUE;
			}
		}
		System.out.println("purchased" + newPurchase);
		return ResponseEntity.ok(newPurchase);
		
	}
}