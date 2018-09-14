package com.example.demo.controller;


import com.example.demo.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/helloA")
    public Item helloWorldA(){
        return new Item();
    }


}
