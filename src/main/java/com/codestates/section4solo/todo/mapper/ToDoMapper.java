package com.codestates.section4solo.todo.mapper;

import com.codestates.section4solo.todo.dto.Dto;
import com.codestates.section4solo.todo.entity.ToDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ToDoMapper {
    ToDo toDoPostDtoToToDo(Dto.TodoPostDto todoPostDto);
    ToDo toDoPatchDtoToToDo(Dto.TodoPatchDto todoPatchDto);
    Dto.TodoResponseDto toDoToToDoResponseDto(ToDo toDo);
    List<Dto.TodoResponseDto> toDosToToDoResponseDtos(List<ToDo> toDos);
}
