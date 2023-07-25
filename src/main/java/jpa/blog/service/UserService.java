package jpa.blog.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jpa.blog.dto.CommentResponseDto;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.entity.User;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	
	private final BCryptPasswordEncoder encoder;
	
	@Transactional
	public void signUp(UserRequestDto.Create dto) {
		dto.setUserPw(encoder.encode(dto.getUserPw()));
		
        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
		dto.setRegDate(now);
		userRepository.save(dto.toEntity());
	}
	
	// 해당 ID 존재 여부 확인
    public boolean findByUserId(String userId) {
    	return userRepository.existsById(userId);
    }
    
    // 아이디, 이름, 소개글, 이미지 조회
    public UserResponseDto.userSimpleInfo userSimpleInfo(String userId) {
    	
    	User userRead = userRepository.findByUserId(userId);
    	
    	UserResponseDto.userSimpleInfo userSimpleInfo = new UserResponseDto.userSimpleInfo(userRead);
    	
    	return userSimpleInfo;
    }
}
