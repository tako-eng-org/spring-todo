package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
  @RequestMapping("/") // URIを指定する
  public String index() {
    // TODO 処理
    return "hello"; // viewのファイル名を拡張子なしで記述する
  }

  // 登録処理
  @PostMapping(value = "/register")
  public String register() {
    // TODO 処理
    // ここに登録のためのModel呼び出しを記載する？
    return "";
  }

  // 削除処理
  @PostMapping(value = "/remove")
  public String remove() {
    // TODO 処理
    return "";
  }

}