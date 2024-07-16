package net.javaguides.todo_management.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.todo_management.dto.TodoDto;
import net.javaguides.todo_management.entity.Todo;
import net.javaguides.todo_management.exception.ResourceNotFoundException;
import net.javaguides.todo_management.repository.TodoRepository;
import net.javaguides.todo_management.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        Todo todo = modelMapper.map(todoDto, Todo.class);

        Todo savedTodo = todoRepository.save(todo);

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id: " + id)
        );
        TodoDto todoDto = modelMapper.map(todo, TodoDto.class);

        return todoDto;
    }

    @Override
    public List<TodoDto> getAllTodo() {
        List<Todo> todoList = todoRepository.findAll();
        List<TodoDto> todoDtoList = todoList.stream().map((todo) -> modelMapper.map(todo, TodoDto.class)).toList();
        return todoDtoList;
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id: " + id)
        );
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());

        Todo updateTodo = todoRepository.save(todo);

        TodoDto updatedTodoDto = modelMapper.map(updateTodo, TodoDto.class);

        return updatedTodoDto;
    }

    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id: " + id)
        );
        todoRepository.delete(todo);
    }

    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Todo not found with id: " + id)
        );
        todo.setCompleted(!todo.isCompleted());
        Todo updatedTodo = todoRepository.save(todo);

        TodoDto updatedTodoDto = modelMapper.map(updatedTodo, TodoDto.class);
        return updatedTodoDto;
    }
}
