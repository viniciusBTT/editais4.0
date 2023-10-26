package com.br.sunioweb.editais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class GlobalSecurity { 
    
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception
    {
        http.authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/home").permitAll()
                                .requestMatchers("/auth").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((formLogin) ->
                        formLogin
                                .loginPage("/auth")
                                .defaultSuccessUrl("/home", true)
                )
                .logout((logout) ->
                        logout.logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                );


        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }   
    
    
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    } 
    
    @Bean
    public AuthenticationManager authenticationManager 
        (AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }
   
}
