package com.cubeitcorp.navit.services.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cubeitcorp.navit.models.User;
import com.cubeitcorp.navit.repositories.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	 private UserRepository userRepository;

	    public UserDetailsServiceImpl(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username" + username));
	        return UserDetailsImpl.build(user);
	    }
	}
