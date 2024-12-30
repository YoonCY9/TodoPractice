package yoon.Todo.list;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import yoon.Todo.toDo.ToDoService;

import java.util.List;

@RestController
public class ToDoListRestController {

    private final ToDoListService toDoListService;
    private final ToDoService toDoService;

    public ToDoListRestController(ToDoListService toDoListService, ToDoService toDoService) {
        this.toDoListService = toDoListService;
        this.toDoService = toDoService;
    }

    @PostMapping("/lists")
    public void create(@Valid @RequestBody CreateListDTO list) {
        toDoListService.create(list);
    }

    @GetMapping("/lists")
    public List<ToDoListResponse> read() {
        return toDoListService.read();
    }

    @GetMapping("/lists/{listId}")
    public ListAllRead allRead(@PathVariable Long listId) {
        return toDoListService.allRead(listId);
    }



    @PutMapping("lists/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody CreateListDTO dto) {
        toDoListService.update(id, dto);
    }

    @DeleteMapping("/lists/{id}")
    public void delete(@PathVariable Long id) {
        toDoListService.delete(id);
    }
}
