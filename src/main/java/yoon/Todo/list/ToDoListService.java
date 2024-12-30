package yoon.Todo.list;

import org.springframework.stereotype.Service;
import yoon.Todo.toDo.ToDo;
import yoon.Todo.toDo.ToDoRepository;
import yoon.Todo.toDo.ToDoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;
    private final ToDoRepository toDoRepository;

    public ToDoListService(ToDoListRepository toDoListRepository, ToDoRepository toDoRepository) {
        this.toDoListRepository = toDoListRepository;
        this.toDoRepository = toDoRepository;
    }

    public void create(CreateListDTO list) {
        ToDoList list1 = new ToDoList(list.title());
        toDoListRepository.save(list1);
    }

    public List<ToDoListResponse> read() {
        List<ToDoList> alls = toDoListRepository.findAll();
        return alls.stream().map(a -> new ToDoListResponse(a.getTitle(), a.getId())).toList();
    }

    public ListAllRead allRead(Long listId) {
        // 해당 아디값에 맞는 todo들 리스트 생성
        List<ToDo> toDos = toDoRepository.findByListId(listId);
        // 그 리스트를 ToDoResponse로 변환
        List<ToDoResponse> aa =
                toDos.stream().map(t -> new ToDoResponse(t.getTitle(),t.getId()))
                        .toList();
        return new ListAllRead(listId, toDoListRepository.
                findById(listId).orElseThrow().getTitle(), aa);
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
