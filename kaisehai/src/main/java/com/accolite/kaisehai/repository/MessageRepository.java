/**
 * 
 */
package com.accolite.kaisehai.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.kaisehai.entity.Message;

/**
 * @author balwant.singh
 *
 */

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

	// find messages for particular user using pagination
	@Query("from Message as m where m.user.id =:userId")
	public List<Message> findMessagesByUser(@Param("userId") Integer userId, Pageable pageable);
}
