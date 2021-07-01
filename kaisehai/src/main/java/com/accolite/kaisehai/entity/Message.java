/**
 * 
 */
package com.accolite.kaisehai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

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
@RedisHash("Message")
public class Message {

	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	private String message;
	
	@ManyToOne
	User user;
}
