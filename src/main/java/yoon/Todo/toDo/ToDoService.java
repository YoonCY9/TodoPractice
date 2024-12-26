package yoon.Todo.toDo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository repository;

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void create(ToDoDTO dto) {
        repository.save(new ToDoEntity(dto.getTitle()));
    }

    public List<ToDoResponse> allRead() {
        List<ToDoEntity> alls = repository.findAll();
        return alls.stream().map(a -> new ToDoResponse(a.getTitle(), a.getId())).toList();
    }

    public void update(Long id,ToDoDTO dto) {
        ToDoEntity toDo = repository.findById(id).orElseThrow();
        toDo.setTitle(dto.getTitle());
        repository.save(toDo);
    }

    public void delete(Long id) {
        ToDoEntity toDo = repository.findById(id).orElseThrow();
        repository.delete(toDo);
    }
}
