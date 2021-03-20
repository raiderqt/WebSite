package com.WebSite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
//	@Qualifier("sessionRegistry")
	private SessionRegistry sessionRegistry;

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		//http.authorizeRequests()
		//		.antMatchers("/", "/food", "/static/image", "/basket").permitAll()
		//		.anyRequest().authenticated()
		//		.and()
		//		.formLogin()
		//		.loginPage("/login")
		//		.permitAll()
		//		.and()
		//		.logout()


		http.authorizeRequests()
				.antMatchers("/admin")
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and().sessionManagement().invalidSessionUrl("/").maximumSessions(1).sessionRegistry(sessionRegistry);
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService()
	{
		UserDetails user =
				User.withDefaultPasswordEncoder()
						.username("1")
						.password("1")
						.roles("USER")
						.build();

		return new InMemoryUserDetailsManager(user);
	}
}