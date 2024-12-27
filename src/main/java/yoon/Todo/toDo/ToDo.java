package yoon.Todo.toDo;

import jakarta.persistence.*;
import yoon.Todo.list.ToDoList;

@Entity
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean completed = false;

    @ManyToOne
    private ToDoList list;

    public ToDo() {
    }


    public ToDo(String title, ToDoList list) {
        this.title = title;
        this.list = list;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
