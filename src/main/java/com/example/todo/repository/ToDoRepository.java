package com.example.todo.repository;

import com.example.todo.domain.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository  extends JpaRepository<ToDo, Long> {
//JpaRepository 이용하고 있기에 추가, 삭제 항목을 만들때 서비스를 따로 구현하지 않아도 되는 장점이 있다. 편하다!
}