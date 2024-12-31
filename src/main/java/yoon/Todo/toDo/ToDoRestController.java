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

    @GetMapping("/completed")
    public List<ToDoCompletedDTO> completedRead() {
        return service.completedRead();
    }

    @GetMapping("/specific/{id}")
    public List<ToDoSpecificDTO> specific(@PathVariable Long id) {
        return service.specificRead(id);
    }

    @GetMapping("/titles/{title}")
    // 목록에 관계 없이, 할 일 ‘검색Search’
    public List<ToDoSearchResponse> toDoSearch(@PathVariable String title) {
        return service.search(title);
    }

    @PutMapping("/titles/complete/{id}")
    public void isCompleted(@PathVariable Long id, @Valid @RequestBody ToDoCompletedDTO dto) {
        service.isCompleted(dto);
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
