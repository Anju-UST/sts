package com.ust.security.config;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class EmpSecurityConfig extends WebSecurityConfigurerAdapter{
//setting up the environment by configuration of resources
	@Autowired
	DataSource dataSource;//automatic dependency injection of the DataSource object.connection to database
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
		//This method is overridden from the WebSecurityConfigurerAdapter class. It configures the authentication manager. In this case, it sets up JDBC authentication,
		//indicating that the authentication should be based on a database using the provided dataSource.
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	@Bean
	@SuppressWarnings("deprecation")
	public PasswordEncoder getPasswordEncoder() {
		//The implementation used here is NoOpPasswordEncoder.getInstance(), which is a deprecated password encoder. 
		//It means that the passwords are stored as plain text, which is not recommended for production environments.
		return NoOpPasswordEncoder.getInstance();
	}
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		//who can access which end points
		//authorization
		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasRole("USER")
		.antMatchers("/").permitAll().and().formLogin();
	}
}

//http.authorizeRequests(): Begins configuring the authorization rules for the requests.
//
//.antMatchers("/admin").hasRole("ADMIN"): Specifies that the "/admin" endpoint should be accessible only to users with the role "ADMIN".
//
//.antMatchers("/user").hasRole("USER"): Specifies that the "/user" endpoint should be accessible only to users with the role "USER".
//
//.antMatchers("/").permitAll(): Specifies that the root endpoint ("/") should be accessible to all users, regardless of their role.
//
//.and().formLogin(): Indicates that a form-based login should be enabled for authentication.
