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

    // service 에서는 파라미터를 DTO타입으로 받기 때문에 JPA로 처리하기 위해서는 Entity 타입의 객체로 변환해야 하는 작업이 반드시 필요하다
    // java 8 버전부터 인터페이스의 실제 내용을 가지는 코드는 default라는 키워드로 생성할 수 있다 -> 실제 코드를 인터페이스에 선언할 수 있다
    // => 추상클래스를 생략하는것이 가능해 졌다
	
	@Transactional
	public void signUp(UserRequestDto dto) {
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
}
