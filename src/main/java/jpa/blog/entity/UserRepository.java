package jpa.blog.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByUserId(String user_id);

	Long save(String userId);
}
