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

@Controller
public class HomeController {
  @Autowired // DI.newしなくても使えるようになる
  TodoRepository todoRepository;

  @RequestMapping("/") // URIを指定する
  public String index() {
    return "list"; // viewのファイル名を拡張子なしで記述する
  }

  // 一覧表示処理
  @GetMapping(value = "/list")
  public String list(Model model) {
    // ここでしていること→generated name を使用して、この Map に提供された属性を追加します。
    // ここでしていることは？
    model.addAttribute("todo", new Todo());
    return "list";
  }

  // 登録処理
  @PostMapping(value = "/list")
  public String registerSubmit(@ModelAttribute Todo todo, Model model) {
    model.addAttribute("list", todo);
    // todo.setBody("TEST");
    // todoRepository.save(todo);
    return "result";
  }

  // // 削除処理
  // @PostMapping(value = "/remove")
  // public String remove() {
  // // TODO 処理
  // return "";
  // }

}