/**
 * 
 */
package com.accolite.kaisehai.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
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
