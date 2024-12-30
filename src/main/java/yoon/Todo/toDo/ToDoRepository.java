package yoon.Todo.toDo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByCompleted(boolean completed);
    // id값을 받아서 해당 아디값에 맞는 toDo들을 반환
    List<ToDo> findByListId(Long listId);
}
