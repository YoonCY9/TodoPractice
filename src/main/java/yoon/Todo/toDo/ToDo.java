package yoon.Todo.toDo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    public ToDo(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ToDo(Long id) {
        this.id = id;
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
