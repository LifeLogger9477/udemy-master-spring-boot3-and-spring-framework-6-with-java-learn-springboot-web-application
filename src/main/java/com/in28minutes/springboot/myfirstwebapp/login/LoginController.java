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

  @RequestMapping (value = "/login")
  public String gotoLoginPage(@RequestParam String name, ModelMap modelMap) {

    modelMap.put( "name", name );

    return "login";
  }
}
