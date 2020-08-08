package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
  @RequestMapping("/") // URIを指定する
  public String index() {
    return "hello"; // viewのファイル名を拡張子なしで記述する
  }

  // todolistの一覧表示をする
  @RequestMapping("/todolist")
  public String getTodolist() {
    return "todolist";
  }

  // todolistの登録をする

}