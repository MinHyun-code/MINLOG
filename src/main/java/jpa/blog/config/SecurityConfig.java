package jpa.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jpa.blog.security.AuthFailureHandler;
import jpa.blog.security.AuthSuccessHandler;
import jpa.blog.security.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;

// CustomUserDetailsService 생성자 주입을 위한 lombok
@RequiredArgsConstructor
// 싱글톤 유지
@Configuration
//@Configuration에 @EnableWebSecurity를 추가해 Spring Security 설정
@EnableWebSecurity 
//특정 주소로 접근하면 권한 및 인증을 미리 체크하기 위해 사용
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	private final CustomUserDetailsService customUserDetailsService;
	
    @Autowired
    AuthFailureHandler authFailureHandler;
    
    @Autowired
    AuthSuccessHandler authSuccessHandler;
 
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Spring Security에서 모든 인증 처리는 AuthenticationManager를 통해 이루어짐, AuthenticationManager를 생성하기 위해 AuthenticationManagerBuilder 사용
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(encoder());
	}

	// 인증을 무시할 경로 설정, static 하위 폴더는 무조건 접근 가능해야하여 인증 무시
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring().antMatchers( "/css/**", "/js/**", "/img/**", "/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/", "/signUp/**","/login/**", "/read/**", "/imgSave").permitAll() // 해당 경로로 접근 허용
			.anyRequest().authenticated();	 //antMatchers 외의 경로는 인증을 요구
		http.formLogin()
			.loginPage("/login")	// 로그인 페이지 지정
			.loginProcessingUrl("/login/action") // 로그인 처리 URL 지정
			.successHandler(authSuccessHandler)
			.failureHandler(authFailureHandler);
		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout/action")) // 로그아웃 URL 지정
			.logoutSuccessUrl("/login") // 성공 리턴 URL
			.invalidateHttpSession(true) // 인증 정보 지우고 세션을 무효화
			.deleteCookies("JSESSIONID", "remember-me"); // JSESSIONID, remember-me 쿠키 삭제
//		http.sessionManagement()
//			.maximumSessions(1)	//세션 최대 허용 수 1, -1인 경우 무제한 세션 허용
//			.maxSessionsPreventsLogin(false)	//true면 중복 로그인을 막고, false면 이전 로그인의 세션을 해제
//			.expiredUrl("/login/error=true&exception=Have been attempted to login from a new place. or session expired"); // 세션이 만료된 후 이동할 페이지 URL
//		http.rememberMe()	// 로그인 유지
//			.key("0467EC591838570F48CC386CEE6ED9FBA53B4593A283BAFD5A94347AD3428408") // 토큰 생성 시 키 값 
//			.alwaysRemember(false)	// 항상 기억할 것인지 여부
//			.tokenValiditySeconds(43200) // in seconds, 12시간 유지
//			.rememberMeParameter("remember-me");	// remember-me 파라미터 이름 지정
	}
}