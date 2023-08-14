package com.example.todo.controller;

import com.example.todo.domain.ToDo;
import com.example.todo.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController  {
    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    //todolist 항목 추가
    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        //db에 저장하면 된다.
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/";
    }
//todolist 항목 삭제
    @PostMapping("/delete/{id}")
    //@PathVariable를 이용해서 id를 받아옴
    public String deleteTodo(@PathVariable Long id){
        toDoRepository.deleteById(id); // 받아온 id로 해당 항목 삭제
        return "redirect:/"; //초기화면으로 이동
    }
}