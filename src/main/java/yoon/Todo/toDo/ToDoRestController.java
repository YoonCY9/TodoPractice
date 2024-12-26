package yoon.Todo.toDo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoRestController {

    private final ToDoService service;

    public ToDoRestController(ToDoService service) {
        this.service = service;
    }

    @PostMapping("/titles")
    public void create(@Valid @RequestBody ToDoDTO dto) {
        service.create(dto);
    }

    @GetMapping("/titles")
    public List<ToDoResponse> allRead() {
        return service.allRead();
    }

    @PutMapping("/titles/{id}")
    public void update(@Valid @RequestBody ToDoDTO dto, @PathVariable Long id) {
        service.update(id,dto);
    }

    @DeleteMapping("titles/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
