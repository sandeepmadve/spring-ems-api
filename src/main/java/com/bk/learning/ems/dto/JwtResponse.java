package com.bk.learning.ems.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -3384326805077141445L;
	
	private String jwtToken;

	public String getJwtToken() {
		return jwtToken;
	}
	
}
