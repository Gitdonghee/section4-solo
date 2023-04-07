package com.codestates.section4solo.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Dto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TodoPostDto{
        private String title;
        private int toDoOrder;
        private boolean completed;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TodoPatchDto{
        private long toDoId;
        private String title;
        private int toDoOrder;
        private boolean completed;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class TodoResponseDto{
        private Long toDoId;
        private String title;
        private int toDoOrder;
        private boolean completed;
    }
}
