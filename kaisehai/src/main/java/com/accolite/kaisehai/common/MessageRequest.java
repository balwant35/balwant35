/**
 * 
 */
package com.accolite.kaisehai.common;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	private Integer sender;
	
	@NotNull
	private Integer receiver;
	
}
