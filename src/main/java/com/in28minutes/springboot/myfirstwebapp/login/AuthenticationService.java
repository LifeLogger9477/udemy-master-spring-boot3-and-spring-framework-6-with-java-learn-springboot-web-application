package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

/**
 * author : ms.Lee
 * date   : 2024-01-19
 */
@Service
public class AuthenticationService {

  public boolean authenticate(String username, String password) {

    boolean isValidUserName =
        username.equalsIgnoreCase( "in28minutes" );
    boolean isValidPassword =
        password.equalsIgnoreCase( "dummy" );

    return isValidUserName && isValidPassword;
  }
}
