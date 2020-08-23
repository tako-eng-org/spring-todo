package com.example.demo.controller;

import com.example.demo.jpa.todos.TodoRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.example.demo.jpa.todos.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.format.DateTimeFormatter;

@Controller
public class EditController {
  @Autowired // DI.newしなくても使えるようになる
  TodoRepository todoRepository;

  // ホーム画面で編集ボタンを押したときの処理
  @GetMapping(value = "/{id}")
  public String show(@PathVariable int id, Model model) {
    Todo todo = todoRepository.findById(id).orElse(null);
    System.out.println(todo.getCreatedDate());
    model.addAttribute("todo", todo);
    // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY/MM/DD HH:mm:ss");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    model.addAttribute("createdDate", todo.getCreatedDate());
    // model.addAttribute("lastModifiedDate",
    // todo.getLastModifiedDate().format(dtf));
    return "edit";
  }

  // 更新画面で「変更して更新」ボタンを押したときの処理
  @PostMapping(value = "/{id}/update")
  public String update(@PathVariable int id, Model model, Todo todo) {
    Todo updateTodo = todoRepository.findById(id).orElse(null);
    // nullだったらエラーハンドリング
    updateTodo.setBody(todo.getBody());
    todoRepository.save(updateTodo);
    return "redirect:/";
  }

  // @PostMapping(value = "/update")
  // public String update(Model model) {
  // System.out.println("test");
  // return "update";
  // }
}