package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author : ms.Lee
 * date   : 2024-01-12
 */
@Controller
public class LoginController {

  // /login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp

  // http://localhost:8080/login?name=Ranga

  // Model 개념 도입
  @RequestMapping (value = "/login")
  public String gotoLoginPage(@RequestParam String name, ModelMap modelMap) {

    modelMap.put( "name", name );

    // NOT RECOMMENDED FOR PROD CODE
    System.out.println("Request param is " + name);

    return "login";
  }
}
