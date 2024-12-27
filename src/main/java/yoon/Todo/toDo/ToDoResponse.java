package yoon.Todo.toDo;

import jakarta.validation.constraints.Size;

public record ToDoResponse(
        @Size(min = 1, max = 10)
        String title,
        Long id) {
}
