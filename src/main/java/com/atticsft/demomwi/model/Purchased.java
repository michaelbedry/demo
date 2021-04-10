/**
 * Purchased -- entity describing the content of a purchase database record
 */
package com.atticsft.demomwi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author michaelbedry
 *
 */
@Data
@Entity
public class Purchased {
	
	
	// Constructors
	
	public Purchased(Long itemId, LocalDateTime datePurchased, Double price, Boolean priceUpdated ) {
		this.itemId = itemId;
		this.datePurchased = datePurchased;
		this.price = price;
		this.priceUpdated = priceUpdated;
	}
		
	public Purchased() {
		super();
	}


	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "item_id", nullable = false)
	@Getter
	@Setter
	private Long itemId;

	@Column(name = "date_purchased", nullable = false)
	@Getter
	@Setter
	private LocalDateTime datePurchased;
	

	@Column(nullable = false)
	@Getter
	@Setter
	private Double price;
	
	// this field is not a column but is used for price updating logic
	private Boolean priceUpdated;
	
	public void setPriceUpdated(Boolean priceUpdated) {
		this.priceUpdated = priceUpdated;
	}
	
	public Boolean isPriceUpdated() {
		return priceUpdated;
	}
}
