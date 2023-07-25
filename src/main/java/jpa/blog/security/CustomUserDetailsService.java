package jpa.blog.security;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jpa.blog.entity.User;
import jpa.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
 
	private final UserRepository userRepository;
 
	private final HttpSession session;

	/* username이 DB에 있는지 확인 */
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		User user = userRepository.findByUserId(userId);
		if(user == null) {
			throw new UsernameNotFoundException("해당 사용자가 존재하지 않습니다. : " + userId);
		}
		session.setAttribute("user", new UserSessionDto(user));
	 
		/* 시큐리티 세션에 유저 정보 저장 */
		return new CustomUserDetails(user);
	}
}