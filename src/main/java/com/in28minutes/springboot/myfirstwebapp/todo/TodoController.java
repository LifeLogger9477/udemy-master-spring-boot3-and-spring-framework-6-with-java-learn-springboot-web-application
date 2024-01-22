package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-19
 */
@Controller
@SessionAttributes ("name")
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

  @RequestMapping (value = "/add-todo", method = RequestMethod.GET)
  public String showNewTodoPage() {

    return "todo";
  }

  @RequestMapping (value = "/add-todo", method = RequestMethod.POST)
  public String addNewTodoPage(
      @RequestParam String description,
      ModelMap model
  ) {

    String username = (String) model.get( "name" );
    todoService.addTodo(
        username,
        description,
        LocalDate.now().plusYears( 1 ),
        false
    );

    return "redirect:list-todos";
  }
}
