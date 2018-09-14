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
    public String addToDo(@RequestParam int id, @RequestParam String value, @RequestParam boolean checked) {
        this.toDoList.add(new Item(id, value, checked));
        return "Success!";
    }


    @DeleteMapping("/todos")
    public String deleteToDo(@RequestParam int id) {
        Item target = this.toDoList.stream().filter(item -> item.getId() == id).findFirst().get();
        this.toDoList.remove(target);
        return "Success!";
    }

    @PutMapping("/todos")
    public String updateToDo(@RequestParam int id, @RequestParam String newValue){
        Item target = this.toDoList.stream().filter(item -> item.getId() == id).findFirst().get();
        target.setValue(newValue);
        return "Success!";
    }

}
