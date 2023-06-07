package jpa.blog.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // �α��� ���� �� ���� �������� ���� ���
        String redirectURL = "/board";
        SavedRequest savedRequest = requestCache.getRequest(request,response);
        if(savedRequest != null){
            // ���� �ޱ� �� url�� �̵��ϱ�
            redirectURL = savedRequest.getRedirectUrl();
        }
        
        response.getWriter().print("{\"redirectURL\": \""+redirectURL+"\"}");
        response.getWriter().flush();
    }
}