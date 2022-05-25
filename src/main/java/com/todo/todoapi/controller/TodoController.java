package com.todo.todoapi.controller;

import com.todo.todoapi.entity.Todo;

import com.todo.todoapi.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin
@RestController
public class TodoController {

   @Autowired
    private TodoService service;


   @GetMapping("/api/todos")
    public List<Todo> list() {
       System.out.println("Request to /todos has been made");
       return service.listAll();
   }
   @GetMapping("/api/todos/{id}")
   public ResponseEntity<Todo> get(@PathVariable Integer id) {
       System.out.println("Request post new /todos has been made");
       try {
           Todo todo = service.get(id);
           return new ResponseEntity<Todo>(todo, HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
       }
   }

    @PostMapping("/api/todos")
    public void add(@RequestBody Todo todo) {
        service.save(todo);
    }

    @PutMapping("/api/todos/{id}")
    public ResponseEntity<?> update(@RequestBody Todo todo, @PathVariable Integer id) {
        try {
            Todo existProduct = service.get(id);
            service.save(todo);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/api/todos/{id}")
    public void delete(@PathVariable Integer id){
       service.delete(id);
    }
}
