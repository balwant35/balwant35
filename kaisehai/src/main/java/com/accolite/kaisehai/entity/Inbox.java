/**
 * 
 */
package com.accolite.kaisehai.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	private User sender;
	private User receiver;
	private Message message;
	private Date sendTime;
	
}
