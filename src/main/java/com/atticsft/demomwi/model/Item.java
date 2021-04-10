/**
 * Item -- entity describing the content of a Item database record
 */
package com.atticsft.demomwi.model;

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
public class Item {
	

	// Constructors
	
	public Item() {
		super();
	}

	public Item(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, unique = true)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String description;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private Double price;
	
	
	
}
