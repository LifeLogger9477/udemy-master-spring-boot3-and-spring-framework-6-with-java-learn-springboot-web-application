package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * author : ms.Lee
 * date   : 2024-01-12
 */
@Controller
@SessionAttributes("name")    // -> 사용하려는 컨트롤러에 다 써야 한다.
public class LoginController {

  private AuthenticationService authenticationService;

  public LoginController(AuthenticationService authenticationService) {

    this.authenticationService = authenticationService;
  }

  // login
  @RequestMapping (value = "/login", method = RequestMethod.GET)
  public String gotoLoginPage() {

    return "login";
  }

  // login?name=Ranga RequestParam
  @RequestMapping (value = "/login", method = RequestMethod.POST)
  public String gotoWelcomePage(
      @RequestParam String name,
      @RequestParam String password,
      ModelMap model
  ) {

    if (authenticationService.authenticate( name, password )) {

      model.put( "name", name );
      // model.put( "password", password );

      // 단일 책임 준수

      // Authentication
      // name - in28minutes
      // password - dummy

      return "welcome";
    }

    model.put( "errorMessage", "Invalid Credentials! Please try again." );

    return "login";
  }
}
