package com.example.demo.controller;

import com.example.demo.jpa.todos.TodoRepository;
import com.example.demo.jpa.todos.Todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.sql.Timestamp;

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
    model.addAttribute("createdDate", todo.getCreatedDate());
    return "edit";
  }

  // 更新画面で「変更して更新」ボタンを押したときの処理
  @PostMapping(value = "/{id}/update")
  public String update(@PathVariable int id, Model model, Todo todo) {
    Todo updateTodo = todoRepository.findById(id).orElse(null);
    // nullだったらエラーハンドリング
    updateTodo.setBody(todo.getBody());
    updateTodo.setLastModifiedDate(new Timestamp(System.currentTimeMillis()));
    todoRepository.save(updateTodo);
    return "redirect:/";
  }
}