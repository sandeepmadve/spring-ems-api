package com.bk.learning.ems.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.bk.learning.ems.service.JwtUserDetailsService;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity
		.csrf().disable()
		//don't authenticate this perticular request
		.authorizeRequests().antMatchers("/authenticate").permitAll()
		//rest all request should be authenticated
		.anyRequest().authenticated()
		.and()
		//add authentication entry point for exception
		.exceptionHandling()
		.authenticationEntryPoint(jwtAuthenEntryPoint)
		.and()
		//make sure to use stateless session. session wont be used to store session store
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		//add filter to validate every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}


//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//

//	/**
//	 * Authentication
//	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		/**
//		 * LDAP Authentication 
//		 */
//		//		authenticationManagerBuilder
//		//			.ldapAuthentication()
//		//			.userDnPatterns("uid={0},ou=people")
//		//				.groupSearchBase("ou=groups")
//		//				.contextSource()
//		//				.url("ldap://localhost:8389/dc=springframework,dc=org")
//		//			.and()
//		//			.passwordCompare()
//		//				.passwordEncoder(new BCryptPasswordEncoder())
//		//				.passwordAttribute("userPassword");
//
//
//		/**
//		 *  JPA Authentication (DataBase)
//		 */
//		authenticationManagerBuilder
//		.userDetailsService(userDetailsService)
//		.passwordEncoder(bCryptPasswordEncoder);
//
//	}
//
//	/**
//	 * Authorization and to protect request from CSRF, XSS, Clickjacking, and so on.
//	 */
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		/**
//		 * LDAP Authorization 
//		 */
////		httpSecurity
////		.authorizeRequests()
////		.anyRequest()
////		.fullyAuthenticated()
////		.and()
////		.formLogin();
//
//		/**
//		 *  JPA Authorization (DataBase)
//		 */
//		httpSecurity
//		.authorizeRequests()
//			.antMatchers("/").permitAll()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/registration").permitAll()
//			.antMatchers("/emp/list").permitAll()
//			.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//			.fullyAuthenticated()
//		.and()
//		.formLogin()
//			.failureUrl("/login?error=true")
//			.defaultSuccessUrl("/admin/home")
//			.usernameParameter("user_name")
//			.passwordParameter("password")
//		.and()
//		.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/login")
//		.and()
//		.exceptionHandling()
//			.accessDeniedPage("/access-denied");
//		
//	}
//	
//	
//	/**
//	 * To ignore requests protected from CSRF, XSS, Click jacking... by Spring security
//	 */
//	@Override
//	public void configure(WebSecurity webSecurity) {
//		webSecurity
//		.ignoring()
//		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//		
//	}


}