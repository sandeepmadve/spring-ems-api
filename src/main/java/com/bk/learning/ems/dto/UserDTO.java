package com.bk.learning.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private int userId;
	private String userName;
	private String email;
	private String firstName;
	private String lastName;
	private boolean active;
	
}
