package com.todo.todoapi.service;

import com.todo.todoapi.entity.Todo;
import com.todo.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TodoService {
    @Autowired
    private TodoRepository repo;

    public List<Todo> listAll(){
        return repo.findAll();
    }
    public void save(Todo todo){
        System.out.println(todo.getId());
        repo.save(todo);
    }

    public Todo get(Integer id){
        return repo.findById(id).get();
    }

    public void delete(Integer id){
        repo.deleteById(id);
    }
}
