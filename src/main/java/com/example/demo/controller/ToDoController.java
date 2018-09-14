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
    public ArrayList<Item> addToDo(@RequestParam String value, @RequestParam boolean checked) {
        int size = this.toDoList.size();
        int id;
        if (size == 0) {
            id = 1;
        } else {
            id = this.toDoList.get(size - 1).getId() + 1;
        }
        this.toDoList.add(new Item(id, value, checked));
        return this.toDoList;
    }


    @DeleteMapping("/todos/{id:\\d+}")
    public String deleteToDo(@PathVariable("id") int id) {
        Item target = this.toDoList.stream().filter(item -> item.getId() == id).findFirst().get();
        this.toDoList.remove(target);
        return "Success!";
    }

    @PutMapping("/todos/{id:\\d+}")
    public String updateToDo(@PathVariable("id") int id, @RequestParam String newValue) {
        Item target = this.toDoList.stream().filter(item -> item.getId() == id).findFirst().get();
        target.setValue(newValue);
        return "Success!";
    }

}
