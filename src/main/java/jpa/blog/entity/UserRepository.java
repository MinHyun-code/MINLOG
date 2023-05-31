package jpa.blog.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.blog.dto.UserDto;

public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByUserId(String user_id);

}
