package jpa.blog.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	@Transactional
	public void boardAdd(BoardRequestDto boardDto) {
		
        // ���� ��¥ ���ϱ�
        LocalDateTime now = LocalDateTime.now();
        
        boardDto.setRegDate(now);
		boardRepository.save(boardDto.toEntity());
	}
	
}
