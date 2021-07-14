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

import com.accolite.kaisehai.entity.Inbox;

/**
 * @author balwant.singh
 *
 */

@Repository
public interface InboxRepository extends JpaRepository<Inbox, Integer> {

	// find messages for particular user using pagination
	@Query("from Inbox as i where i.receiver.id =:userId")
	public List<Inbox> findInboxesByReceiver(@Param("userId") Integer userId, Pageable pageable);
}
