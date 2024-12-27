package yoon.Todo.list;

import org.springframework.stereotype.Service;
import yoon.Todo.toDo.ToDoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public void create(CreateListDTO list) {
        ToDoList list1 = new ToDoList(list.title());
        toDoListRepository.save(list1);
    }

    public List<ToDoListResponse> read() {
        List<ToDoList> alls = toDoListRepository.findAll();
        return alls.stream().map(a -> new ToDoListResponse(a.getTitle(), a.getId())).toList();
    }

    public List<ToDoListResponse> taskCount(Long id) {
        int count = 0;
    }

    public void update(Long id, CreateListDTO dto) {
        ToDoList list1 = toDoListRepository.findById(id).orElseThrow();
        list1.setTitle(dto.title());
        toDoListRepository.save(list1);
    }


    public void delete(Long id) {
        ToDoList list1 = toDoListRepository.findById(id).orElseThrow();
        toDoListRepository.delete(list1);
    }
}
