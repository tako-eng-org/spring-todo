package com.example.demo.controller;

import com.example.demo.jpa.todos.TodoRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.example.demo.jpa.todos.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.data.domain;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
  @Autowired // DI.newしなくても使えるようになる
  TodoRepository todoRepository;

  // 一覧表示処理
  @GetMapping(value = "/") // URIを指定する
  public String index(Model model, Todo todo) {
    model.addAttribute("todo", new Todo());
    // ページのentityを取得する
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html?is-external=true#findAll-org.springframework.data.domain.Pageable-
    List<Todo> list = todoRepository.findAll();
    model.addAttribute("allRecords", list);
    return "list"; // viewのファイル名を拡張子なしで記述する
  }

  // 登録処理
  @PostMapping(value = "/")
  public String registerSubmit(@ModelAttribute Todo todo, Model model) {
    model.addAttribute("todo", todo);
    todo.setBody(todo.getBody());
    todoRepository.save(todo);
    return index(model, todo);
  }

  // 削除処理
  @PostMapping(value = "/remove")
  public String removeSubmit(@ModelAttribute Todo todo, Model model) {
    boolean myBooleanVariable = false;
    // model.addAttribute("myBooleanVariable", myBooleanVariable);
    model.getAttribute("removeId");
    todoRepository.delete(id);
    return index(model, todo);
  }

}