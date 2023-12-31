package com.api.ars.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.ars.repositories.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    UserRepository userRepo;

    @Autowired
    JWTFilter filter;

    @Autowired
    UserDetailsServiceImpl uds;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
		        .cors()
		        .and()
        		.csrf().disable()
                .httpBasic().disable()
                .authorizeHttpRequests()
                .antMatchers("/user/registro", "/user/login").permitAll()
//                .antMatchers("funcionario/atualizar/{id}").hasRole("FUNCIONARIO")
//                .antMatchers("funcionario/salvar", "funcionario/listar", "funcionario/ativar/{id}", "funcionario/remover/{id}", "/departamento/listar", "/departamento/salvar", "/departamento/atualizar/{id}", "/departamento/ativar/{id}", "/departamento/remover/{id}", "/gerente/listar", "/gerente/salvar", "/gerente/atualizar/{id}", "/gerente/ativar/{id}", "/gerente/remover/{id}", "/setor/listar", "/setor/salvar", "/setor/atualizar/{id}", "/setor/remover/{id}").hasRole("GERENTE")
//                .antMatchers("funcionario/atualizar/{id}", "funcionario/buscar/{id}", "/setor/buscar/{id}", "/departamento/buscar/{id}", "/gerente/buscar/{id}").hasAnyRole("GERENTE", "FUNCIONARIO")
                .and()
                .userDetailsService(uds)
                .exceptionHandling()
                    .authenticationEntryPoint(
                            (request, response, authException) ->
                                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                    )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }
	
}