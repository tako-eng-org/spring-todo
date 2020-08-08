package com.example.demo.controller;

import com.example.demo.jpa.todos.TodoRepository;
import com.example.demo.jpa.todos.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @Autowired // DI.newしなくても使えるようになる
  TodoRepository todoRepository;

  @RequestMapping("/") // URIを指定する
  public String index() {
    return "todolist"; // viewのファイル名を拡張子なしで記述する
  }

  // 登録処理
  @PostMapping(value = "/register")
  public String register(Todo todo) {
    todo.setBody("TEST");
    todoRepository.save(todo);
    return "";
  }

  // // 削除処理
  // @PostMapping(value = "/remove")
  // public String remove() {
  // // TODO 処理
  // return "";
  // }

}