package yoon.Todo.toDo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    public ToDoEntity() {
    }

    public ToDoEntity(String title) {
        this.title = title;
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
