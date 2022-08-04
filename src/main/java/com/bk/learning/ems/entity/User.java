package com.bk.learning.ems.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TBL_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;

	@NotEmpty(message = "*Please provide user name")
	@Length(min = 5, max=50, message = "*User name must have atleast 5 characters")
	@Column(name = "username")
	private String userName;

	@Length(min = 5, max=50, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Column(name = "password")
	private String password;

	@NotEmpty(message = "*Please provide an email")
	@Email(message = "*Please provide valid a email")
	@Column(name = "email")
	private String email;

	@NotEmpty(message = "*Please provide your first name")
	@Column(name = "first_name")
	private String firstName;

	@NotEmpty(message = "*Please provide your last name")
	@Column(name = "last_name")
	private String lastName;

	@Column(name = "active")
	private boolean active;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
			)
	private Set<Role> roles;



}
