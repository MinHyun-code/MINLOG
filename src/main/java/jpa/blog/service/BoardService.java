package jpa.blog.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import jpa.blog.dto.BoardRequestDto;
import jpa.blog.dto.BoardResponseDto;
import jpa.blog.dto.UserRequestDto;
import jpa.blog.dto.UserResponseDto;
import jpa.blog.entity.Board;
import jpa.blog.entity.User;
import jpa.blog.repository.BoardList;
import jpa.blog.repository.BoardRepository;
import jpa.blog.repository.CommentList;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	private final ImageService imageService;
	private final UserService userService;
    
	static String os = System.getProperty("os.name").toLowerCase();
	
	@Transactional
	public void boardWrite(BoardRequestDto.Create boardDto, String user_id) {
		
        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();

        User user = userRepository.findByUserId(user_id);
        
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        
        String boardSeq = boardRepository.boardSeqCnt(Integer.toString(year), String.format("%02d", month), String.format("%02d", day));
        
        
        // TEMP 폴더에 있는 이미지 옮기기 + 기존 폴더 삭제
        if(os.contains("win")) {
            File tempFolder = new File("C:/MinLOG/board/temp/" + user_id);
            File moveFolder = new File("C:/MinLOG/board/" + boardSeq);
            
            // 디렉토리 생성
            boolean directoryCreated1 = tempFolder.mkdirs();
            boolean directoryCreated2 = moveFolder.mkdirs();
            
            imageService.copy(tempFolder, moveFolder);
            imageService.delete(tempFolder.toString());
		} else {
			File tempFolder = new File("../../../img/board/temp/" + user_id);
			File moveFolder = new File("../../../img/board/" + boardSeq);
			
	        // 디렉토리 생성
	        boolean directoryCreated1 = tempFolder.mkdirs();
	        boolean directoryCreated2 = moveFolder.mkdirs();
	        
	        imageService.copy(tempFolder, moveFolder);
	        imageService.delete(tempFolder.toString());
			
		}
        
        boardDto.setContent(boardDto.getContent().replace("temp/"+user_id, boardSeq));
        boardDto.setThumbnail(boardDto.getThumbnail().replace("temp/"+user_id, boardSeq));
        boardDto.setRegDate(now);
        boardDto.setDelYn("N");
        boardDto.setUserId(user);
        boardDto.setBoardSeq(boardSeq);

        boardRepository.save(boardDto.toEntity());
	}
	
	public List<BoardResponseDto.BoardList> boardList() {

		// 등록 순서대로 보여주기 (나중에 등록된 것 위로)
		List<BoardList> boardList = new ArrayList<BoardList>();
		
		boardList = boardRepository.findMainBoardList();
		
		List<BoardResponseDto.BoardList> boardDtoList = new ArrayList<>();
		
		for(int i=0; i<boardList.size(); i++) {
			boardDtoList.add(new BoardResponseDto.BoardList(boardList.get(i)));
		}
		return boardDtoList;
	}
	
	public BoardResponseDto.BoardDetail boardDetail(String boardSeq) {

		BoardResponseDto.BoardDetail boardDetail = new BoardResponseDto.BoardDetail(boardRepository.findByBoardSeq(boardSeq));
		
		return boardDetail;
	}
	
	
	@Transactional
    public void boardDelete(String boardSeq) {
    	
    	Board boardDetail = boardRepository.findByBoardSeq(boardSeq);

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
    	boardDetail.changeDelYn("Y", now);
    }
	
	@Transactional
	public void boardUpdate(BoardRequestDto.Create boardDto) {
		Board boardInfo = boardRepository.findByBoardSeq(boardDto.getBoardSeq());

        // 현재 날짜 구하기
        LocalDateTime now = LocalDateTime.now();
        
        boardDto.setUpDate(now);
        
		boardInfo.changeBoard(boardDto);
	}
}
