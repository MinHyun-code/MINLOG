package jpa.blog.dto;

import java.util.Calendar;

public class FileNameModel {
	
	public FileNameModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String GenSaveFileName(String extName) {
		// TODO Auto-generated constructor stub
		String fileName = "";
		
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH);
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += extName;
		
		return fileName;
	}
}