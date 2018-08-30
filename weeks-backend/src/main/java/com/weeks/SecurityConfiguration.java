package com.weeks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.weeks.user.repository.UserRepository;
import com.weeks.util.security.CustomLoginFailureHandler;
import com.weeks.util.security.CustomLoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.cors();
		http
			.csrf().disable();
		http
			.authorizeRequests()
				.antMatchers("/user/login", "/user/register").permitAll()
				.anyRequest().authenticated();
		http
			.formLogin()
				.successHandler(new CustomLoginSuccessHandler())
				.failureHandler(new CustomLoginFailureHandler());
//				.loginProcessingUrl("/user/login");
//				.loginPage("user/login");
				
		http
			.logout()
				.logoutUrl("/user/logout")
				.invalidateHttpSession(true);
	}

}
