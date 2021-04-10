/**
 * ItemRepository -- defines Spring repository for the Item entity
 */
package com.atticsft.demomwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atticsft.demomwi.model.Item;

/**
 * @author michaelbedry
 *
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{

	public Item findByName(String name);
}
