package jpa.blog.common;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {

	// ��üũ
    public static String paramNullCheck(HttpServletRequest request, String paramName, String returnVal) {
        return request.getParameter(paramName)==null?returnVal:request.getParameter(paramName);
    }
    
    // ��� ��ϳ�¥ ���ϱ�
    public static String commentDayDiff(LocalDateTime regDate) {

    	// ���� ��¥ ���ϱ�
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
        	regDateResult = "�ٷ�";
        }else if(dayDiff < minute){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / seconds)) + "��";
            //�к��� ������ ����������
          }else if(dayDiff < hour){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / minute)) + "��";
            //�ú��� ������ ���������
          }else if(dayDiff < day){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / hour)) + "�ð�";
            //�Ϻ��� ������ ��ð������� 
          }else if(dayDiff < month){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / day)) + "��";
            //�޺��� ������ ���� ������
          }else if(dayDiff < year){
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / month)) + "��";
            //�⺸�� ������ ���������
          }else{
        	  regDateResult = String.format("%.0f", Math.floor(dayDiff / year)) + "��";
          }
        
        regDateResult += " ��";
        
    	return regDateResult;
    }
    
    
    // �Խñ� ��� ��¥ ���ϱ�
    public static String boardDayDiff(LocalDateTime regDate) {

    	// ���� ��¥ ���ϱ�
    	LocalDateTime now = LocalDateTime.now();
    	
        Long dayDiff = Duration.between(regDate, now).toSeconds();
		
        int seconds = 1;
        int minute = seconds * 60;
        int hour = minute * 60;
        int day = hour * 24;
        int month = day * 30;
        
        String regDateResult = "";
        
        if(dayDiff < seconds) {
        	regDateResult = "�ٷ� ��";
        }else if(dayDiff < minute){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / seconds)) + "��";
            //�к��� ������ ����������
         }else if(dayDiff < hour){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / minute)) + "��";
            //�ú��� ������ ���������
         }else if(dayDiff < day){
        	regDateResult = String.format("%.0f", Math.floor(dayDiff / hour)) + "�ð�";
            //�Ϻ��� ������ ��ð������� 
          }else if(dayDiff < month){
        	String weekDiff = String.format("%.0f", Math.floor(dayDiff / day));
        	if(Integer.parseInt(weekDiff) >= 7) {
        		regDateResult = regDate.format(DateTimeFormatter.ofPattern("yyyy�� MM�� dd��"));
            	return regDateResult;
        	} else {
        		regDateResult = weekDiff + "��";
        	}
          }
        
        regDateResult += " ��";
        
    	return regDateResult;
    }
}
