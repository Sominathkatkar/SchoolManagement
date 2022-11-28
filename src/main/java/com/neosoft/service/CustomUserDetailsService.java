package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.entity.User;
import com.neosoft.entity.UserDetailsInfo;
import com.neosoft.repository.UserRepossitory;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepossitory userrepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = this.userrepo.findByUsername(username);
		
	if(user==null) {
		throw new UsernameNotFoundException("User not found");
	}
	
	return new UserDetailsInfo(user);
	}

}
