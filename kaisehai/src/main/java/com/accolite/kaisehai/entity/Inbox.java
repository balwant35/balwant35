/**
 * 
 */
package com.accolite.kaisehai.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
public class Inbox {

	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	private User sender;
	
	@OneToOne
	private User receiver;
	
	@OneToOne
	private Message message;
	
	@NotEmpty
	private Date sendTime;
	
}
