package yoon.Todo.list;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoListRestController {

    private final ToDoListService service;

    public ToDoListRestController(ToDoListService service) {
        this.service = service;
    }

    @PostMapping("/lists")
    public void create(@Valid @RequestBody CreateListDTO list) {
        service.create(list);
    }

    @GetMapping("/lists")
    public List<ToDoListResponse> read() {
        return service.read();
    }

    @PutMapping("lists/{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody CreateListDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping("/lists/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
