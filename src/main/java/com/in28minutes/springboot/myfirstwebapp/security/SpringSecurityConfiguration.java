package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * author : ms.Lee
 * date   : 2024-01-25
 */
@Configuration
public class SpringSecurityConfiguration {

  // LDAP or Database
  // in Memory

  @Bean
  public InMemoryUserDetailsManager createUserDetailManager() {

    // InMemoryUserDetailsManager
    // InMemoryUserDetailsManager(UserDetails... users)

//    Function<String, String> passwordEncoder =
//        input -> passwordEncoder().encode( input );

    UserDetails userDetails1 = createNewUser(
        "in28minutes",
        "dummy"
    );

    UserDetails userDetails2 = createNewUser(
        "ranga",
        "dummydummy"
    );

    return new InMemoryUserDetailsManager( userDetails1, userDetails2 );
  }

  private UserDetails createNewUser(String username, String password) {

    UserDetails userDetails = User.builder()
        .passwordEncoder( input -> passwordEncoder().encode( input ) )
        .username( username )
        .password( password )
        .roles( "USER", "ADMIN" )
        .build();

    return userDetails;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }

  // all urls are protected
  // a login form is shown for unauthorized requests
  // csrf disable
  // frames

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
        auth -> auth.anyRequest().authenticated()
    );

    http.formLogin( withDefaults());

    http.csrf( AbstractHttpConfigurer::disable );
    http.headers(
        headersConfigurer ->
            headersConfigurer.frameOptions(
                HeadersConfigurer.FrameOptionsConfig::disable
            )
    );

    return http.build();
  }
}
