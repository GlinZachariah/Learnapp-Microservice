package dev.glinzac.learnappauth.controller;

import java.util.Collection;
import java.util.List;

import dev.glinzac.learnappauth.config.CustomCredentials;
import dev.glinzac.learnappauth.config.JwtTokenUtil;
import dev.glinzac.learnappauth.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.glinzac.learnappauth.models.JwtRequest;
import dev.glinzac.learnappauth.models.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    //	@RequestMapping(value="/performAuth",method = RequestMethod.POST)
//	public UserDetailsModel performAuth(@RequestBody CredentialsModel loginData) {
//		return userService.authenticate(loginData);
//	}
    @RequestMapping(value = "/users/performAuth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//		System.out.println("The erorr is found here first. ");
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//		System.out.println("the value is "+authenticationRequest.getUsername());
//		System.out.println("the password is "+authenticationRequest.getPassword());
        final CustomCredentials userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

	/*@RequestMapping(value = "users/performAuth", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		System.out.println(" =>> The user full name is : "+userDetails.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}*/

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
