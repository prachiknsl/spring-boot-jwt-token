package com.geekytech.securityjwttoken.controller;

import com.geekytech.securityjwttoken.config.CustomUserDetailsService;
import com.geekytech.securityjwttoken.model.AuthenticationRequest;
import com.geekytech.securityjwttoken.model.AuthenticationResponse;
import com.geekytech.securityjwttoken.model.UserDTO;
import com.geekytech.securityjwttoken.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        log.info("Inside authenticate controller");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        }catch (DisabledException e){
            log.error("Error : USER_DISABLED");
            throw new Exception("USER_DISABLED",e);
        }
        catch (BadCredentialsException e){
            log.error("Error : INVALID_CREDENTIALS");
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        UserDetails userDetails =userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        log.info("Inside register controller");
        return ResponseEntity.ok(userDetailsService.save(user));
    }
}
