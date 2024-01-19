package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

/**
 * author : ms.Lee
 * date   : 2024-01-19
 */
public class TodoService {

  private static List<Todo> todos;
  static {

    todos.add(
        new Todo(
            1,
            "in28minutes",
            "Learn AWS",
            LocalDate.now().plusYears( 1 ),
            false
        )
    );
    todos.add(
        new Todo(
            1,
            "in28minutes",
            "Learn DevOps",
            LocalDate.now().plusYears( 2 ),
            false
        )
    );
    todos.add(
        new Todo(
            1,
            "in28minutes",
            "Learn Full Stack Development",
            LocalDate.now().plusYears( 3 ),
            false
        )
    );
  }

  public List<Todo> findByUsername(String username) {

    return todos;
  }
}