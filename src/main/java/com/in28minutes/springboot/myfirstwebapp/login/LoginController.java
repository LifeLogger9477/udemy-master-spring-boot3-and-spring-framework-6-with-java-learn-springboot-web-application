package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author : ms.Lee
 * date   : 2024-01-12
 */
@Controller
public class LoginController {

  // login
  @RequestMapping (value = "/login")
  public String gotoLoginPage() {

    return "login";
  }
}
