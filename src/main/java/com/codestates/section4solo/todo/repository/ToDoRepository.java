package com.codestates.section4solo.todo.repository;

import com.codestates.section4solo.todo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}
