/**
 * 
 */
package com.accolite.kaisehai.common;

import org.springframework.http.HttpStatus;

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

	private HttpStatus statusCode;
	private String statusMessage;
}
