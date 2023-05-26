package jpa.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
			.ignoring().antMatchers( "/css/**", "/js/**", "/img/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/**", "/login", "/auth/**", "/posts/read/**", "/posts/search/**")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("loginProc")
			.defaultSuccessUrl("/")
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true);
	}
}