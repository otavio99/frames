package br.edu.ifms.TrabalhoFinal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class SpringSecurityConfig {
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
		.withUser("cliente").password("{noop}cliente").roles("CLIENTE")
		.and()
		.withUser("administrador").password("{noop}administrador").roles("ADMIN")
		.and()
		.withUser("atendente").password("{noop}atendente").roles("ATENDENTE");
		
	} 
}
