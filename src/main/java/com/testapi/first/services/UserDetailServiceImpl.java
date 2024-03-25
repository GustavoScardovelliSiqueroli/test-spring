package com.testapi.first.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.testapi.first.repositories.UserRepository;
import com.testapi.first.entities.User;
import com.testapi.first.entities.UserAuthenticated;

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> newUser = userRepository.findByUsername(username);
        if (newUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        UserAuthenticated authUser = new UserAuthenticated();
        BeanUtils.copyProperties(newUser, authUser);
        return authUser;
    }

}
