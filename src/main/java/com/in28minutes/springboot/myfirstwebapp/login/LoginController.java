package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author : ms.Lee
 * date   : 2024-01-12
 */
@Controller
public class LoginController {

  // /login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
  @RequestMapping (value = "/login")
  public String gotoLogin() {

    return "login";
  }
}
