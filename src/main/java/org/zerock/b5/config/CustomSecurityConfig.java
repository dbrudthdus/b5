package org.zerock.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableMethodSecurity		// 어노테이션으로 시큐리티(권한)에 대한 설정 가능하게 함
public class CustomSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

			log.info("-------------configure-------------");

			http.formLogin(Customizer.withDefaults());

			// 권한 차등 메소드
			// http.authorizeHttpRequests(requests -> {
			// 	requests.anyRequest().authenticated();
			// 	// 모든 요청에 대해 인증값을 확인
			// });
			
			return http.build();

	}
                                                                                                                                                                                                                                                                                                                                                                                                              
}