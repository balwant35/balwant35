/**
 * 
 */
package com.accolite.kaisehai.common;

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
public class MessageRequest {

	@NotEmpty
	private String message;
	
	@NotEmpty
	private Integer sender;
	
	@NotEmpty
	private Integer receiver;
	
}
