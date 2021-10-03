package com.geekytech.securityjwttoken.config;

import com.geekytech.securityjwttoken.dao.UserDao;
import com.geekytech.securityjwttoken.model.UserDTO;
import com.geekytech.securityjwttoken.model.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Inside loadUserByUsername method");
        List<SimpleGrantedAuthority> roles = null;
        UserDetail user = userDao.findByUsername(username);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getUsername(), user.getPassword(), roles);
        }
        log.error("User not found with the name "+ username);
        throw new UsernameNotFoundException("User not found with the name " + username);
    }

    public UserDetail save(UserDTO user) {
        log.info("Inside save user detail method");
        UserDetail newUser = new UserDetail();
        newUser.setUsername(user.getUsername());
        //encrypt password
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userDao.save(newUser);
    }
}
