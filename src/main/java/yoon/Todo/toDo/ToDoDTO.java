package yoon.Todo.toDo;

public class ToDoDTO {

    private String title;

    private long listId;

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

    public long getListId() {
        return listId;
    }
}
