package com.codestates.section4solo.todo.controller;

import com.codestates.section4solo.todo.dto.Dto;
import com.codestates.section4solo.todo.dto.MultiResponseDto;
import com.codestates.section4solo.todo.entity.ToDo;
import com.codestates.section4solo.todo.mapper.ToDoMapper;
import com.codestates.section4solo.todo.service.ToDoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@Slf4j
public class ToDoController {
    private final ToDoService toDoService;
    private final ToDoMapper mapper;

    public ToDoController(ToDoService toDoService, ToDoMapper mapper){
        this.toDoService = toDoService;
        this.mapper = mapper;
    }

    @PostMapping
    ResponseEntity PostToDo(@RequestBody Dto.TodoPostDto todoPostDto){
        ToDo toDo = mapper.toDoPostDtoToToDo(todoPostDto);

        ToDo createToDo = toDoService.createToDo(toDo);

        return new ResponseEntity<>(mapper.toDoToToDoResponseDto(createToDo),HttpStatus.CREATED);
    }

    @PatchMapping("/{toDo-id}")
    public ResponseEntity patchToDo(@PathVariable("toDo-id") long toDoId,
                                    @RequestBody Dto.TodoPatchDto todoPatchDto){
        todoPatchDto.setToDoId(toDoId);

        ToDo toDo = toDoService.updateToDo(mapper.toDoPatchDtoToToDo(todoPatchDto));

        return new ResponseEntity<>(mapper.toDoToToDoResponseDto(toDo),HttpStatus.OK);
    }

    @GetMapping("/{toDo-id}")
    public ResponseEntity getToDo(@PathVariable("toDo-id") long toDoId){

        ToDo toDo = toDoService.findToDo(toDoId);

        return new ResponseEntity<>(mapper.toDoToToDoResponseDto(toDo),HttpStatus.OK);

    }
    @GetMapping()
    public ResponseEntity getToDos(@RequestParam int page,
                                   @RequestParam int size){
        Page<ToDo> pageTodos = toDoService.findToDos(page - 1, size);
        List<ToDo> toDos = pageTodos.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(mapper.toDosToToDoResponseDtos(toDos),
                pageTodos),
                HttpStatus.OK);
    }
    @DeleteMapping("/{toDo-id}")
    public ResponseEntity deleteToDo(@PathVariable("toDo-id") long toDoId){
        toDoService.deleteToDo(toDoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
