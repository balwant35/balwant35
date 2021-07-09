/**
 * 
 */
package com.accolite.kaisehai.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;

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
public class Inbox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private User sender;
	
	@OneToOne
	private User receiver;
	
	@OneToOne
	private Message message;
	
	@CreationTimestamp
	private Date sendTime;
	
}
