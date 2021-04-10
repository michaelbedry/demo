/**
 * PurchaseRepository -- used to store purchased items
 */
package com.atticsft.demomwi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atticsft.demomwi.model.Purchased;

/**
 * @author michaelbedry
 *
 */
@Repository
public interface PurchaseRepository extends JpaRepository<Purchased, Long> {
	
	public long countByItemId(long itemId);

}
