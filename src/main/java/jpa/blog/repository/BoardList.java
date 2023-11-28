package jpa.blog.repository;

import java.time.LocalDateTime;

public interface BoardList {
	
	String getBoardSeq();		// �Ϸù�ȣ
	String getTitle();			// ����
	String getUserId();			// �����
	LocalDateTime getRegDate(); // �������
	String getThumbnail();		// ����� �̹���
	String getThumbnailTxt();	// ����� �ؽ�Ʈ
	String getRegUserImg();		// ���� �̹���
	int getCommentCnt();		// ��� ����
	int getLikeCnt();			// ���� ����
}
