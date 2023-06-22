package org.zerock.b5.security;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("loadUserByUsername: " + username);

		UserDetails user = User.builder()
								.username(username)
								.password("$2a$10$GqIZ1shPYaPVUaDC.2C5BepgUX4TGGsupOe8UpqYNd7In.W3dfMm2")	
								// 테스트 코드에서 1111을 복호화 한 암호
								.authorities("ROLE_USER", "ROLE_G1")
								.build();

		return user;

	}
	
}
