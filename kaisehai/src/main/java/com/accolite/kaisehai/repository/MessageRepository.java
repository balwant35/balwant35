/**
 * 
 */
package com.accolite.kaisehai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.kaisehai.entity.Message;

/**
 * @author balwant.singh
 *
 */

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	
}
