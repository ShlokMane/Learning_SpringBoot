package net.javaguides.todo_management.service;

import net.javaguides.todo_management.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

    List<TodoDto> getAllTodo();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);
}
