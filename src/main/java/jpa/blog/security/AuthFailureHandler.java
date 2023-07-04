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
 * �α��� ���� �ڵ鷯
 */
@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                AuthenticationException exception) throws IOException, ServletException {

        String errorCode = "";  // ���� �ڵ�
        String errorMsg = "";   // ���� �޼���

//        if(exception instanceof AuthenticationServiceException){    // ���� �䱸�� �źε��� �� ������ ����
//            errorCode = LoginFailType.AUTH_FAIL.getId();
//            errorMsg = LoginFailType.AUTH_FAIL.getMsg();
//        }

//        if(exception instanceof LockedException){                   // ���� �ź� - ��� ����
//            errorCode = LoginFailType.LOCKED_ACCOUNT.getId();
//            errorMsg = LoginFailType.LOCKED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof DisabledException){                 // ���� �ź� - ���� ��Ȱ��ȭ
//            errorCode = LoginFailType.DISABLED_ACCOUNT.getId();
//            errorMsg = LoginFailType.DISABLED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof AccountExpiredException){           // ���� �ź� - ���� ��ȿ�Ⱓ ����
//            errorCode = LoginFailType.EXPIRED_ACCOUNT.getId();
//            errorMsg = LoginFailType.EXPIRED_ACCOUNT.getMsg();
//        }
//        if(exception instanceof CredentialsExpiredException){       // ���� �ź� - ��й�ȣ ��ȿ�Ⱓ ����
//            errorCode = LoginFailType.EXPIRED_PASSWORD.getId();
//            errorMsg = LoginFailType.EXPIRED_PASSWORD.getMsg();
//        }
        if(exception instanceof BadCredentialsException){         // ���������� ������
            errorCode = "BAD_CREDENTIALS";
            errorMsg = "���̵� Ȥ�� ��й�ȣ�� Ȯ���ϼ���.";
        }

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);    // �����ź�
        response.getWriter().print("{\"errorCode\": \""+errorCode+"\", \"errorMsg\": \""+errorMsg+"\"}");
        response.getWriter().flush();
        //response.sendRedirect("/pages/login?error="+errorCode);
    }
}