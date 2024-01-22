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
    
    // 게시글 등록 날짜 구하기
    public static String dayDiff(LocalDateTime regDate) {

    	// 현재 날짜 구하기
    	LocalDateTime now = LocalDateTime.now();
    	
        Long dayDiff = Duration.between(regDate, now).toSeconds();
		
        int seconds = 1;
        int minute = seconds * 60;
        int hour = minute * 60;
        int day = hour * 24;
        
        String regDateResult = "";
        
        if(dayDiff < seconds) {
        	regDateResult = "바로";
        }else if(dayDiff < minute){
            //분보다 작으면 몇초전인지
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / seconds)) + "초 전";
         }else if(dayDiff < hour){
             //시보다 작으면 몇분전인지
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / minute)) + "분 전";
         }else if(dayDiff < day){
             //일보다 작으면 몇시간전인지 
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / hour)) + "시간 전";
          }else {
        	  // 그 외는 등록날짜
        	  regDateResult = regDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));
          }
    	return regDateResult;
    }
}