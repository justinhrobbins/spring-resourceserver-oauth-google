package org.test.spring.resourceserver.oauth.google;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

@SpringBootApplication
public class SpringResourceserverOauthGoogleApplication extends WebSecurityConfigurerAdapter {
	@Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
	String jwkSetUri;

	public static void main(String[] args) {
		SpringApplication.run(SpringResourceserverOauthGoogleApplication.class, args);
	}

	// @Bean
	// public JwtDecoder jwtDecoder() {
	// 	return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).build();
	// }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests(a -> a
						.antMatchers("/unsecured/**").permitAll()
						.anyRequest().authenticated())
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.cors()
				.and()
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}

}
