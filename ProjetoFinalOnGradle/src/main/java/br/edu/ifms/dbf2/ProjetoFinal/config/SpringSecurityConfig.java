package br.edu.ifms.dbf2.ProjetoFinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SpringSecurityConfig {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
		.withUser("otavio").password("{noop}123").roles("USER") 
		.and()
		.withUser("ot").password("{noop}321").roles("ADMIN");
	} 
}
