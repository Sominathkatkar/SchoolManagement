package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.neosoft.entity.User;
@Repository
public interface UserRepossitory extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
