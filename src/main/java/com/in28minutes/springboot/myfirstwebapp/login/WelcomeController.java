package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * author : ms.Lee
 * date   : 2024-01-12
 */
@Controller
@SessionAttributes("name")    // -> 사용하려는 컨트롤러에 다 써야 한다.
public class WelcomeController {

  // login
  @RequestMapping (value = "/", method = RequestMethod.GET)
  public String gotoWelcomePage(ModelMap model) {

    model.put( "name", "in28minutes" );
    return "welcome";
  }
}