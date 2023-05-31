package jpa.blog.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * 로그인 성공 핸들러
 */
@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
		
        //Http Response Code Set
        response.setStatus(HttpServletResponse.SC_OK);

        // 성공 시 response를 json형태로 반환
        //response.getWriter().print("{\"success\": true}");
        //response.getWriter().flush();
        
        // main redirect
        response.sendRedirect("/board");
    }

}