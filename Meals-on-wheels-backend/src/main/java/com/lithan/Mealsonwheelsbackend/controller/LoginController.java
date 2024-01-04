package com.lithan.Mealsonwheelsbackend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.details.CustomMemberDetails;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.User;
import com.lithan.Mealsonwheelsbackend.repo.UserRepository;
import com.lithan.Mealsonwheelsbackend.requests.LoginRequest;
import com.lithan.Mealsonwheelsbackend.responses.UserDetailResponse;
import com.lithan.Mealsonwheelsbackend.service.UserDetailsServiceImpl;

@CrossOrigin(origins = {"http://localhost:5173"})

@RestController
@RequestMapping("/user-api")
public class LoginController {

	@Autowired
	private UserRepository userRepository;
	
    @Autowired
    private AuthenticationManager authenticationManager;
	
	private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public LoginController(UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
    	this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDetails> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Load UserDetails from the database
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

            // Check if the password is correct
            if (passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
                // Authentication successful

                return ResponseEntity.ok(userDetails);
            } else {
                // Authentication failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }

        } catch (UsernameNotFoundException e) {
            // User not found
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } 
    }
    
  
    


}
    
