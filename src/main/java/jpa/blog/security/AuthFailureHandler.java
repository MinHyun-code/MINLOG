package jpa.blog.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * 로그인 실패 핸들러
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {

        String errorCode = "";  // 에러 코드
        String errorMsg = "";   // 에러 메세지

//        if(exception instanceof AuthenticationServiceException){    // 인증 요구가 거부됐을 때 던지는 예외
//            errorCode = LoginFailType.AUTH_FAIL.getId();
//            errorMsg = LoginFailType.AUTH_FAIL.getMsg();
//        }

//        if(exception instanceof LockedException){                   // 인증 거부 - 잠긴 계정
//            errorCode = LoginFailType.LOCKED_ACCOUNT.getId();
//            errorMsg = LoginFailType.LOCKED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof DisabledException){                 // 인증 거부 - 계정 비활성화
//            errorCode = LoginFailType.DISABLED_ACCOUNT.getId();
//            errorMsg = LoginFailType.DISABLED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof AccountExpiredException){           // 인증 거부 - 계정 유효기간 만료
//            errorCode = LoginFailType.EXPIRED_ACCOUNT.getId();
//            errorMsg = LoginFailType.EXPIRED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof CredentialsExpiredException){       // 인증 거부 - 비밀번호 유효기간 만료
//            errorCode = LoginFailType.EXPIRED_PASSWORD.getId();
//            errorMsg = LoginFailType.EXPIRED_PASSWORD.getMsg();
//        }
        if(exception instanceof BadCredentialsException){         // 계정정보가 없을때
            errorCode = "BAD_CREDENTIALS";
            errorMsg = "아이디 혹은 비밀번호를 확인하세요.";
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);    // 인증거부
        response.getWriter().print("{\"errorCode\": \""+errorCode+"\", \"errorMsg\": \""+errorMsg+"\"}");
        response.getWriter().flush();
        //response.sendRedirect("/pages/login?error="+errorCode);
    }
}