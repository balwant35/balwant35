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
public class MessageResponse {

	private MessageRequest messageRequest;
	private String status;
}
