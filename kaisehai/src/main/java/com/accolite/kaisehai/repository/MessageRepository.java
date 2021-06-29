/**
 * 
 */
package com.accolite.kaisehai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.kaisehai.entity.Message;

/**
 * @author balwant.singh
 *
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {

}
