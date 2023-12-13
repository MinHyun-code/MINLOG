package jpa.blog.common;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	// 널체크
    public static String paramNullCheck(HttpServletRequest request, String paramName, String returnVal) {
        return request.getParameter(paramName)==null?returnVal:request.getParameter(paramName);
    }
    
    // 댓글 등록날짜 구하기
    public static String commentDayDiff(LocalDateTime regDate) {

    	// 현재 날짜 구하기
    	LocalDateTime now = LocalDateTime.now();
    	
        Long dayDiff = Duration.between(regDate, now).toSeconds();
		
        int seconds = 1;
        int minute = seconds * 60;
        int hour = minute * 60;
        int day = hour * 24;
        int month = day * 30;
        int year = month * 12;
        
        String regDateResult = "";
        
        if(dayDiff < seconds) {
        	regDateResult = "바로";
        }else if(dayDiff < minute){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / seconds)) + "초";
            //분보다 작으면 몇초전인지
          }else if(dayDiff < hour){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / minute)) + "분";
            //시보다 작으면 몇분전인지
          }else if(dayDiff < day){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / hour)) + "시간";
            //일보다 작으면 몇시간전인지 
          }else if(dayDiff < month){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / day)) + "일";
            //달보다 작으면 몇일 전인지
          }else if(dayDiff < year){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / month)) + "달";
            //년보다 작으면 몇달전인지
          }else{
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / year)) + "년";
          }
        
        regDateResult += " 전";
        
    	return regDateResult;
    }
    
    
    // 게시글 등록 날짜 구하기
    public static String boardDayDiff(LocalDateTime regDate) {

    	// 현재 날짜 구하기
    	LocalDateTime now = LocalDateTime.now();
    	
        Long dayDiff = Duration.between(regDate, now).toSeconds();
		
        int seconds = 1;
        int minute = seconds * 60;
        int hour = minute * 60;
        int day = hour * 24;
        int month = day * 30;
        
        String regDateResult = "";
        
        if(dayDiff < seconds) {
        	regDateResult = "바로";
        }else if(dayDiff < minute){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / seconds)) + "초";
            //분보다 작으면 몇초전인지
         }else if(dayDiff < hour){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / minute)) + "분";
            //시보다 작으면 몇분전인지
         }else if(dayDiff < day){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / hour)) + "시간";
            //일보다 작으면 몇시간전인지 
          }else if(dayDiff < month){
        	String weekDiff = String.format("%.0f", Math.floor(dayDiff / day));
        	if(Integer.parseInt(weekDiff) >= 7) {
        		regDateResult = regDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
            	return regDateResult;
        	} else {
        		regDateResult = weekDiff + "일";
        	}
          }
        
        regDateResult += " 전";
        
    	return regDateResult;
    }
}