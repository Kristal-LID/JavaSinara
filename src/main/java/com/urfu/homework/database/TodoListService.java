package com.urfu.homework.database;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoListService {
    private final TodoListRepository todoListRepository;

    @Transactional
    public void saveTodoList(TodoListDTO todoListDTO) {
        TodoList todoList = new TodoList(todoListDTO.getName());

        todoListDTO.getEvents().forEach(eventDesc -> {
            Event event = new Event(eventDesc);
            todoList.addEvent(event);
        });

        todoListRepository.save(todoList);
    }

    @Transactional(readOnly = true)
    public List<TodoListDTO> getAllTodoLists() {
        return todoListRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TodoListDTO convertToDTO(TodoList todoList) {
        TodoListDTO dto = new TodoListDTO();
        dto.setName(todoList.getName());
        dto.setEvents(todoList.getEvents().stream()
                .map(Event::getDescription)
                .collect(Collectors.toList()));
        return dto;
    }
}
