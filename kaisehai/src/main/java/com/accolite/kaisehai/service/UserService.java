/**
 * 
 */
package com.accolite.kaisehai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.kaisehai.entity.User;
import com.accolite.kaisehai.repository.UserRepository;

/**
 * @author balwant.singh
 *
 */

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/**
	 * This service is used to add the user in DB
	 * @param user
	 * @return user
	 */
	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getUser(Integer userId) {
		return userRepository.getById(userId);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

}
