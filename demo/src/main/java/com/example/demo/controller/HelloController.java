package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
  @RequestMapping("/hello") // URIを指定する
  public String index() {
    return "hello"; // viewのファイル名を拡張子なしで記述する
  }

  @RequestMapping("/todolist")
  public String test() {
    return "todolist";
  }

}