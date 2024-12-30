package yoon.Todo.list;

import jakarta.persistence.*;
import yoon.Todo.toDo.ToDo;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "list")
    private List<ToDo> toDos = new ArrayList<>();

    public ToDoList() {
    }

    public ToDoList(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
