package jpa.blog.controller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jpa.blog.dto.UserDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.entity.User;
import jpa.blog.entity.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	
	private final BCryptPasswordEncoder encoder;
																																										
	@Transactional
	public Long join(UserDto dto) {
		dto.setUserPw(encoder.encode(dto.getUserPw()));
		
		return userRepository.save(dto.toEntity().getUserId());
	}
	
    public List<UserResponseDto> findAll() {

        Sort sort = Sort.by(Direction.DESC, "id", "regDate");
        List<User> list = new ArrayList<User>();
        
        list = userRepository.findAll();
        
        return list.stream().map(UserResponseDto::new).collect(Collectors.toList());
    }
}
