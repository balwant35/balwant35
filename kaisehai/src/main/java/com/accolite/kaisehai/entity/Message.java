/**
 * 
 */
package com.accolite.kaisehai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

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
public class Message {

	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	private String message;
	
	@ManyToOne
	User user;
}
