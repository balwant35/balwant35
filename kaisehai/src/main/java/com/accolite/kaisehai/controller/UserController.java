/**
 * 
 */
package com.accolite.kaisehai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.kaisehai.common.RedisCacheValue;
import com.accolite.kaisehai.entity.User;
import com.accolite.kaisehai.service.UserService;

/**
 * @author balwant.singh
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User savedUser = userService.addUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	@CachePut(key = "#user.id", value = RedisCacheValue.USER)
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		User savedUser = userService.updateUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.OK);
	}
	
	@GetMapping("/get/{userId}")
	@Cacheable(key = "#userId", value = RedisCacheValue.USER)
	public User getUser(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/delete/{userId}")
	@CacheEvict(key = "#userId", value = RedisCacheValue.USER)
	public boolean deleteUser(@PathVariable("userId") Integer userId) {
		return userService.deleteUser(userId);
	}
}
