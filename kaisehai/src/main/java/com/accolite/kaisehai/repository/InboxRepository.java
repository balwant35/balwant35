/**
 * 
 */
package com.accolite.kaisehai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.kaisehai.entity.Inbox;

/**
 * @author balwant.singh
 *
 */

@Repository
public interface InboxRepository extends JpaRepository<Inbox, Integer> {

}
