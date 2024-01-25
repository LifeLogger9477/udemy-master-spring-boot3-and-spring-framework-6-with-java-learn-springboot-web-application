package com.in28minutes.springboot.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

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

    UserDetails userDetails = User.builder()
        .passwordEncoder( input -> passwordEncoder().encode( input ) )
        .username( "in28minutes" )
        .password( "dummy" )
        .roles( "USER", "ADMIN" )
        .build();

    return new InMemoryUserDetailsManager( userDetails );
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }
}
