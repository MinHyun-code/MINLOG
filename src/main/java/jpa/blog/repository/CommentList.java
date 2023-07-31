package jpa.blog.repository;

import java.time.LocalDateTime;

public interface CommentList {
	
	
	int getCommentSeq();
	String getCommentTxt();
	int getGroupNum();
	LocalDateTime getRegDate();
	String getUserId();
	String getBoardSeq();
	int getDepth();
	int getCommentCnt();
}
