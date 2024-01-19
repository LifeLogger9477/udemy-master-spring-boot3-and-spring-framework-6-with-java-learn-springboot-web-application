package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-19
 */
@Controller
public class TodoController {

  private TodoService todoService;

  public TodoController(TodoService todoService) {

    this.todoService = todoService;
  }

  // /list-todos
  @RequestMapping (value = "/list-todos")
  public String listAllTodos(ModelMap model) {

    List<Todo> todos = todoService.findByUsername( "in28minutes" );
    model.addAttribute( "todos", todos );

    return "listTodos";
  }
}
