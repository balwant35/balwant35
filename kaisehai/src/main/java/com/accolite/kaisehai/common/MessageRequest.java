/**
 * 
 */
package com.accolite.kaisehai.common;

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

	private String message;
	private Integer sender;
	private Integer reciever;
	
}
