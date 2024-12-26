package yoon.Todo.toDo;

public class ToDoDTO {

    String title;

    public ToDoDTO() {
    }

    public ToDoDTO(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
