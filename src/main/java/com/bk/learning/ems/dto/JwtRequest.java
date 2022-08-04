package com.bk.learning.ems.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -906853858970675506L;

	private String username;
	private String password;

}
