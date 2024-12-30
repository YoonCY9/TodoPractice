package yoon.Todo.list;

import yoon.Todo.toDo.ToDo;
import yoon.Todo.toDo.ToDoResponse;

import java.util.List;

public record ListAllRead(Long listId, String title, List<ToDoResponse> toDos) {
}
