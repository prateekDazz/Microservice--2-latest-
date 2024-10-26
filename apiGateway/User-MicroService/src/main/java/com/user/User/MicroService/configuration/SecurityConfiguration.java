package com.user.User.MicroService.configuration;

import com.user.User.MicroService.filter.JwtTokenFilter;
import com.user.User.MicroService.jwt.AuthEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    private AuthEntryPoint authEntryPoint;


    @Bean
    SecurityFilterChain defaultSecurityFilterChain (HttpSecurity http) throws Exception
    {
//        http.authorizeHttpRequests((request)->request.requestMatchers("/signIn/**").permitAll().requestMatchers("/users/getAllUser/**").permitAll()
////                .requestMatchers("/users/**").permitAll()
//                .anyRequest().authenticated());
        http.csrf(csrf -> csrf.disable());
        http.exceptionHandling(e->e.authenticationEntryPoint(authEntryPoint));
        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }
    @Bean
    JwtTokenFilter jwtTokenFilter()
    {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }



    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        System.out.println("authentication manager bean create ho rha h");
        return config.getAuthenticationManager();
    }

}
