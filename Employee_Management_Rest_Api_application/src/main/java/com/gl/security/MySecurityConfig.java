package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService service;
	
	@Bean
    public	AuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider daop = new DaoAuthenticationProvider();
		daop.setUserDetailsService(service);
		daop.setPasswordEncoder(getPasswordEncoder());
		return daop;
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/employees","/employees/{id}","/employees/search/{firstName}","/employees/sort")
		.hasAnyAuthority("admin","user")
		.antMatchers(HttpMethod.POST,"/employees")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.DELETE,"/employees/{id}")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.PUT,"/employees/{id}")
		.hasAnyAuthority("admin")
		.anyRequest().authenticated().and().httpBasic()
		.and().cors().and().csrf().disable(); 
			
}	
}