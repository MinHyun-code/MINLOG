package jpa.blog.repository;

import java.time.LocalDateTime;

public interface CommentList {
	
	
	int getCommentSeq();
	String getCommentTxt();
	int getGroupNum();
	LocalDateTime getRegDate();
	String getUserId();
	int getBoardSeq();
	int getDepth();
	int getCommentCnt();
}
