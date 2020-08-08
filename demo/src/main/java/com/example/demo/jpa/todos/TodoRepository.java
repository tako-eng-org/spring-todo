package com.example.demo.jpa.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
  // Todoモデルを操作する用のリポジトリ
  // CRUDはJpaRepositoryにメソッド実装されているので、新規での実装は不要。
  // https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
}