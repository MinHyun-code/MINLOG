package jpa.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUserId(String user_id);
}
