package com.example.job_search_app.config;

import com.example.job_search_app.exceptions.NotFoundException;
import com.example.job_search_app.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
	private UserRepository userRepository;
	@Bean
	public UserDetailsService userDetailsService(){
		return username -> userRepository.findByEmail(username).orElseThrow(
				() -> new NotFoundException("Not found")
		);
	}
}
