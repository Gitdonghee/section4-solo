package com.codestates.section4solo.todo.service;

import com.codestates.section4solo.exception.BusinessLogicException;
import com.codestates.section4solo.exception.ExceptionCode;
import com.codestates.section4solo.todo.entity.ToDo;
import com.codestates.section4solo.todo.repository.ToDoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToDoService {
    private final ToDoRepository todDoRepository;

    public ToDoService(ToDoRepository todDoRepository){
        this.todDoRepository = todDoRepository;
    }
    public ToDo createToDo(ToDo toDo){

        return todDoRepository.save(toDo);
    }

    public ToDo updateToDo(ToDo toDo){
        ToDo findToDo = findVerifiedToDo(toDo.getToDoId());

        Optional.ofNullable(toDo.getTitle())
                .ifPresent(title -> findToDo.setTitle(title));
        Optional.ofNullable(toDo.getToDoOrder())
                .ifPresent(toDoOrder -> findToDo.setToDoOrder(toDoOrder));
        Optional.ofNullable(toDo.isCompleted())
                .ifPresent(completed -> findToDo.setCompleted(completed));

        return todDoRepository.save(findToDo);
    }

    public ToDo findToDo(long toDoId){
        return findVerifiedToDo(toDoId);
    }

    public Page<ToDo> findToDos(int page, int size){
        return todDoRepository.findAll(PageRequest.of(page,size, Sort.by("toDoOrder").ascending()));
    }

    public void deleteToDo(long toDoId){
        ToDo findToDo = findVerifiedToDo(toDoId);

        todDoRepository.delete(findToDo);
    }

    public ToDo findVerifiedToDo(long todoId){
        Optional<ToDo> optionalToDo =
                todDoRepository.findById(todoId);
        ToDo findToDo =
                optionalToDo.orElseThrow(()->
                            new BusinessLogicException(ExceptionCode.TODO_NOT_FOUND));
        return findToDo;
    }

}
