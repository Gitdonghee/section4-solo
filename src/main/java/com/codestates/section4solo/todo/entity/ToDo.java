package com.codestates.section4solo.todo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long toDoId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int toDoOrder;

    @Column(nullable = false)
    private boolean completed;
}
