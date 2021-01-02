package com.covid.covid.securityConfiguration;

import com.covid.covid.errorHandler.LoginFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(2)
public class SpringBootUserSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private LoginFailureHandler failureHandler;

	@Autowired
	UserDetailsService userDetailsServiceImpl;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")
			.authorizeRequests().
				antMatchers("/register").permitAll()
				.anyRequest().authenticated()
			.and().formLogin().loginPage("/login")
				.failureHandler(failureHandler)
				.defaultSuccessUrl("/dashboard", true)
			.permitAll()
			.and().logout().logoutSuccessUrl("/login");
		
		http.csrf().disable();
	}
}