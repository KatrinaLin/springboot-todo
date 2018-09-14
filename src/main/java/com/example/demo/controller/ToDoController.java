package com.example.demo.controller;


import com.example.demo.Item;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ToDoController {
    private ArrayList<Item> toDoList = new ArrayList<Item>();

    @GetMapping("/todos")
    public ArrayList<Item> showToDoList() {
        return this.toDoList;
    }

    @PostMapping("/todos")
    public Item addToDo(@RequestBody Item item) {
        int size = this.toDoList.size();
        int id;
        if (size == 0) {
            id = 1;
        } else {
            id = this.toDoList.get(size - 1).getId() + 1;
        }
        item.setId(id);
        this.toDoList.add(item);
        return item;
    }

    @DeleteMapping("/todos/{id:\\d+}")
    public void deleteToDo(@PathVariable("id") int id) {
        Item target = this.toDoList.stream().filter(item -> item.getId() == id).findFirst().get();
        this.toDoList.remove(target);
    }

    @PutMapping("/todos/{id:\\d+}")
    public void updateToDo(@PathVariable("id") int id, @RequestBody Item item) {
        Item target = this.toDoList.stream().filter(i -> i.getId() == id).findFirst().get();
        target.setValue(item.getValue());
    }

}
