package com.ust.security.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.security.MyUserDetailsService;
import com.ust.security.model.AuthenticationRequest;
import com.ust.security.model.AuthenticationResponse;
import com.ust.security.util.Jwtutil;

@RestController
public class EmployeeResources {
	@Autowired 
	private AuthenticationManager authenticationManager;
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	Jwtutil jwtUtil;
	
	@GetMapping("/greet")
	public String greet() {
		return "working";
	}
	
//get the token from headers and do authentication
	//post username and password
	

@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
	//this method handles the authentication process. It expects an AuthenticationRequest object in the request body and returns a ResponseEntity containing the authentication result.
               System.out.println(authenticationRequest.getUsername() + authenticationRequest.getPassword());	
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}catch(BadCredentialsException e) {
			
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));	//The token can be sent back to the client as a response to the authentication request.	
	}
//try---this line performs the authentication process using the AuthenticationManager. It creates a UsernamePasswordAuthenticationToken object with the provided username and password and passes it to the authenticate() method of the AuthenticationManager. 
//catch---- (BadCredentialsException e) { throw new Exception("Incorrect username or password", e); }: This block catches the BadCredentialsException that may occur during authentication. If the provided credentials are incorrect, an exception is thrown with a custom error message indicating incorrect username or password.
//This line loads the UserDetails object for the authenticated user by calling the loadUserByUsername() method of the UserDetailsService implementation. It retrieves the user details from the underlying user store (e.g., database) based on the provided username.

//final String jwt = jwtUtil.generateToken(userDetails): This line generates a JWT (JSON Web Token) for the authenticated user. It uses a jwtUtil object 
}
	