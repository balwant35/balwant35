/**
 * 
 */
package com.accolite.kaisehai.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author balwant.singh
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@RedisHash("User")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	private String name;
	
	@Size(min = 10, message = "Mobile number should have atleast 10 digit")
	private String mobileNum;
	
	@NotEmpty
	@Email
	private String email;
	
	@OneToMany
	List<Message> messages;
}
