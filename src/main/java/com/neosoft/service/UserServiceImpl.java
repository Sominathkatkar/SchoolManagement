package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.entity.User;
import com.neosoft.repository.UserRepossitory;
@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserRepossitory userrepo;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveuser() {

		User user = new User();
		user.setUsername("mangesh");
		user.setPassword(this.bCryptPasswordEncoder.encode("mangesh"));
		user.setEmail("mangesh@gmail.com");
		user.setRole("NORMAL");

		this.userrepo.save(user);
		
		User user1 = new User();
		user1.setUsername("mangesh");
		user1.setPassword(this.bCryptPasswordEncoder.encode("mangesh"));
		user1.setEmail("mangesh@gmail.com");
		user1.setRole("NORMAL");

		this.userrepo.save(user1);

	}

}
