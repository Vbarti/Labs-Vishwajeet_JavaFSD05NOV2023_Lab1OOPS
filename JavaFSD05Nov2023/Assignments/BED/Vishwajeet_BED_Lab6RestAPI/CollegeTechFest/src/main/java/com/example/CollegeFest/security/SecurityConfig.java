package com.example.CollegeFest.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.CollegeFest.serviceimpl.UserDtlServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDtlServiceImpl userDetailsServiceImpl;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider ssrsDaoAuthenticationProvider() {

      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

      authProvider.setUserDetailsService(userDetailsServiceImpl);
      authProvider.setPasswordEncoder(passwordEncoder());

      return authProvider;
    }   
    
    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .requestMatchers("/", "/students/list").hasAnyAuthority("ADMIN", "USER")
//            .requestMatchers("/students/add", "/students/update/**", "/students/delete/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/students/list").permitAll()
//            .and()
//            .logout().logoutSuccessUrl("/login").permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/students/403")
//            .and()
//            .csrf().disable();
//        
//        http.authenticationProvider(ssrsDaoAuthenticationProvider());
//        
//        return http.build();
//    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      http.authorizeRequests()
        .requestMatchers("/","/students/list").hasAnyAuthority("ADMIN", "USER")
        .requestMatchers("/students/add", "/students/update/**", "/students/delete/**").hasAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/students/list").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/students/403")
        .and()
        .cors().and().csrf().disable();
      
      http.authenticationProvider(ssrsDaoAuthenticationProvider());
      return http.build();
    }

   
}
