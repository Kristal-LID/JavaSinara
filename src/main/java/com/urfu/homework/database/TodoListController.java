package com.urfu.homework.database;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo-lists")
@RequiredArgsConstructor
public class TodoListController {
    private final TodoListService todoListService;

    @PostMapping
    public void saveTodoList(@RequestBody TodoListDTO todoListDTO) {
        todoListService.saveTodoList(todoListDTO);
    }

    @GetMapping
    public List<TodoListDTO> getAllTodoLists() {
        return todoListService.getAllTodoLists();
    }
}
