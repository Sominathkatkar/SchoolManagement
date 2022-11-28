package com.neosoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.neosoft.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class MySecurityAdapter extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeHttpRequests()
		//.antMatchers("/signIn").permitAll()
		.antMatchers("/welcome","/signIn")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		// .loginPage("/signIn")
		//.loginProcessingUrl("/StudentController/getAll");

	
	}

	@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 
	 auth.userDetailsService(customUserDetailsService).passwordEncoder(encode());
	 
	 /*
	 * auth.inMemoryAuthentication().withUser("sam").password("sam").roles("admin");
	 * auth.inMemoryAuthentication().withUser("john").password("john").roles(
	 * "student");
	 */
}

	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
}
