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
    
    // 유저 정보 조회
    public UserResponseDto.userInfo userInfo(String userId) {
    	
    	User userRead = userRepository.findByUserId(userId);
    	
    	UserResponseDto.userInfo userInfo = new UserResponseDto.userInfo(userRead);
    	
    	return userInfo;
    }
    
    // 유저 정보 수정
    @Transactional
    public void userInfoUpdate(UserRequestDto.Create dto) {

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
    	User userInfo = userRepository.findByUserId(dto.getUserId());
    	
    	// 비밀번호 변경 안했을 경우, 기존 값 넣기
    	if(dto.getUserPw() == null || dto.getUserPw().equals("")) {
    		dto.setUserPw(userInfo.getUserPw());
    	} else {
    		dto.setUserPw(encoder.encode(dto.getUserPw()));
    	}
    	
    	// 등록일자는 변하지 않아서 기존 값 넣기
    	dto.setRegDate(userInfo.getRegDate());
    	dto.setModDate(now);
    	userInfo.changeUser(dto);
    }
}