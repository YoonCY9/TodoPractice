package yoon.Todo.toDo;

import org.springframework.stereotype.Service;
import yoon.Todo.list.ToDoList;
import yoon.Todo.list.ToDoListRepository;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository repository;

    private final ToDoListRepository toDoListRepository;

    public ToDoService(ToDoRepository repository, ToDoListRepository toDoListRepository) {
        this.repository = repository;
        this.toDoListRepository = toDoListRepository;
    }

    public void create(ToDoDTO dto) {
        ToDoList toDoList = toDoListRepository.findById(dto.getListId()).orElseThrow();
        repository.save(new ToDo(dto.getTitle(),toDoList));
    }

    public List<ToDoResponse> allRead() {
        List<ToDo> alls = repository.findAll();
        return alls.stream().map(a -> new ToDoResponse(a.getTitle(), a.getId())).toList();
    }

    public List<ToDoSpecificDTO> specificRead(Long id) {
        List<ToDo> specs = repository.findByListId(id);
        return specs.stream().map(s -> new ToDoSpecificDTO(s.getTitle(), s.getId())).toList();
    }

    public List<ToDoSearchResponse> search(String title) {
        // 목록에 관계없이 해당 문자열이 포함된 할일리스트 조회
        List<ToDo> toDos = repository.findByTitleContaining(title);
        return toDos.stream().map(t -> new ToDoSearchResponse(t.getTitle(),t.getId(),t.isCompleted())).toList();
    }

    public List<ToDoCompletedDTO> completedRead() {
        List<ToDo> completeds = repository.findByCompleted(true);
        return completeds.stream().map(c -> new ToDoCompletedDTO(c.getId(),c.getTitle(), c.isCompleted())).toList();
    }

    public void isCompleted(ToDoCompletedDTO dto) {
        ToDo toDo = repository.findById(dto.id()).orElseThrow();
        toDo.setCompleted(dto.completed());
        repository.save(toDo);
    }

    public void update(Long id,ToDoDTO dto) {
        ToDo toDo = repository.findById(id).orElseThrow();
        toDo.setTitle(dto.getTitle());
        repository.save(toDo);
    }

    public void delete(Long id) {
        ToDo toDo = repository.findById(id).orElseThrow();
        repository.delete(toDo);
    }

    public ToDoSearchResponse toDoSerch(Long id) {
        ToDo toDo = repository.findById(id).orElseThrow();
        return new ToDoSearchResponse(toDo.getTitle(), toDo.getId(), toDo.isCompleted());
    }
}
