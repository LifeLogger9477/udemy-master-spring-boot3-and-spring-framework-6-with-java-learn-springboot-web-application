package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author : ms.Lee
 * date   : 2024-01-11
 */
@Controller
public class SayHelloController {

  // "say-hello" => "Hello! What are you learning today?"

  // say-hello
  @ResponseBody
  @RequestMapping (value = "/say-hello")
  public String sayHello() {

    return "Hello! What are you learning today?";
  }
}
