/**
 * 
 */
package com.accolite.kaisehai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.kaisehai.entity.User;

/**
 * @author balwant.singh
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
