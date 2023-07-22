package com.smadoku.app.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		// REST API 利用によって、 CSRF トークン生成機能除外。
		.csrf().disable();
		http
//		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		// 以後 Token発行より先にすいこうしたいURLがある場合は antMatchersについかしてください。
		.antMatchers("/**")
			.permitAll().anyRequest().authenticated()
			.and()
			.cors();
		// 認証の際、ROLEチェック。
	}
	
	@Bean
	CorsConfigurationSource configurationSource () {
		CorsConfiguration configuration = new CorsConfiguration();
		
		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		
		return source;
		
	}
}
