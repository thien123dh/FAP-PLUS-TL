package com.example.fap_plus.config;

import com.example.fap_plus.service.UsersDetailServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UsersDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> {
                    req
                            .requestMatchers("/student/**").hasAnyAuthority("STUDENT")
                            .requestMatchers("/staff/**").hasAnyAuthority("STAFF")
                            .requestMatchers("/teacher/**").hasAnyAuthority("TEACHER")
                            .anyRequest().authenticated();
                });
//        http.formLogin(Customizer.withDefaults());
        http.formLogin(form -> form
                .usernameParameter("userName")
                .passwordParameter("password")
                .successHandler(( request, response, authentication ) -> {
                            response.setHeader( "Location", "Your angular url");
                            response.setHeader( "message", "authenticated" ); // <-custom http header as redirection does not allow content inside response body
                            response.setStatus( HttpServletResponse.SC_FOUND ); // <- redirection status
                        }
                )
                .failureHandler(
                        (request, response, authenticationException ) -> {
                            response.setHeader( "Location", "Your angular url");
                            response.setHeader( "message", "error" );
                            response.setStatus( HttpServletResponse.SC_FOUND);
                        }));
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
