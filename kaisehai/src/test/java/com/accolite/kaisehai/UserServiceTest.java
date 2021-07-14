/**
 * 
 */
package com.accolite.kaisehai;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accolite.kaisehai.entity.User;
import com.accolite.kaisehai.repository.UserRepository;
import com.accolite.kaisehai.service.UserService;

/**
 * @author balwant.singh
 *
 */

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	@Mock
	UserService userService;
	
	@Test
	public void getUserByIdTest() {
		
		User expectedUser = new User(694514746, "balwant", "9590518203", "balwant@acco.com");
		Mockito.when(userRepository.findById(694514746)).thenReturn(Optional
				.of(expectedUser));
		
		User actualUser = userService.getUser(694514746);
		
		Assertions.assertThat(actualUser.getId()).isEqualByComparingTo(expectedUser.getId());
	}
	
	@Test
	public void getAllUsersTest() {
		
		List<User> expectedUsers = Stream.
				of(new User(694514746, "user1", "9590518203", "user1@acco.com"), 
				   new User(694514747, "user2", "9590518203", "user2@acco.com"), 
				   new User(694514748, "user3", "9590518203", "user3@acco.com"))
				.collect(Collectors.toList());
		
		Mockito.when(userRepository.findAll()).thenReturn(expectedUsers);
		
		List<User> actualUsers = userService.getAllUsers();
		
		Assertions.assertThat(actualUsers.size()).isEqualTo(expectedUsers.size());
	}
	
	@Test
	public void addUserTest() {
		
		User expectedUser = new User();
		expectedUser.setName("balwant");
		expectedUser.setId(111);
		expectedUser.setEmail("balwant@acco.com");
		expectedUser.setMobileNum("9590518203");
		
		Mockito.when(userRepository.save(expectedUser)).thenReturn(expectedUser);
		
		User actualUser = userService.addUser(expectedUser);
		
		Assertions.assertThat(actualUser.getName()).isEqualTo(expectedUser.getName());
	}
	
	@Test
	public void updateUserTest() {
		
		User expectedUser = new User();
		expectedUser.setName("balwant");
		expectedUser.setId(111);
		expectedUser.setEmail("balwant@acco.com");
		expectedUser.setMobileNum("9590518203");
		
		Mockito.when(userRepository.save(expectedUser)).thenReturn(expectedUser);
		
		User actualUser = userService.updateUser(expectedUser);
		
		Assertions.assertThat(actualUser.getName()).isEqualTo(expectedUser.getName());
	}
	
	@Test
	public void deleteUserTest() {

		boolean actualResult = userService.deleteUser(694514746);
		Assertions.assertThat(actualResult).isTrue();
	}
}
