/**
 * 
 */
package com.accolite.kaisehai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accolite.kaisehai.entity.User;

/**
 * @author balwant.singh
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
