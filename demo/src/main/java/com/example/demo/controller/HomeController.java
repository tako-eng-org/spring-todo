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
    // viewと共有する変数の定義
    model.addAttribute("todo", new Todo());
    // ページのentityを取得する
    // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html?is-external=true#findAll-org.springframework.data.domain.Pageable-
    List<Todo> list = todoRepository.findAll();
    model.addAttribute("allRecords", list);
    return "list"; // viewのファイル名を拡張子なしで記述する
  }

  // 登録処理
  @PostMapping(value = "/register")
  public String register(@ModelAttribute Todo todo, Model model) {
    // 登録処理において、viewの表示は行っていないため、この定義は不要。
    // model.addAttribute("todo", todo);
    // todo.setBody(todo.getBody());
    todoRepository.save(todo);
    // return index(model, todo);
    // index -> register -> index
    // index -> submit -> register -> ブラウザにredirect指示(indexへ) -> index表示
    return "redirect:/";
  }

  // 削除処理
  @PostMapping(value = "/remove")
  public String remove(int id[], Model model) {
    // 複数のidを受け取る
    // todoの配列をもらう or idの配列をもらう
    // for文でOK。いつものやNG。拡張for文でかく。
    for (int removeId : id) {
      todoRepository.deleteById(removeId);
    }
    return "redirect:/";
  }

  // 更新処理
  // 編集ボタンを押下したら、内容を編集できる画面に遷移する。

}