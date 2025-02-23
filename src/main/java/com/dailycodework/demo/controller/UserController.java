package com.dailycodework.demo.controller;

import com.dailycodework.demo.model.User;
import com.dailycodework.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
    private IUserService userService;
    @GetMapping
    public ResponseEntity<List<User>>getUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.FOUND);

    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/update/{id}")
    public  User updateUser(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }











}
