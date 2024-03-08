package com.example.application_dev.controller;

import com.example.application_dev.Entity.UserEntity;
import com.example.application_dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private JdbcTemplate jdbsTemplate;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try
        {
            userRepository.save(user);
            //return ResponseEntity.ok("Пользователь успешно сохранён");
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка post");
        }
        try
        {
            jdbsTemplate.update("Insert into users(first_name, last_name) values (?,?)", user.getFirstName(), user.getLastName());
            return ResponseEntity.ok("Пользователь успешно сохранён");
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body("jdbs insert failed");
        }
    }
    @GetMapping
    public ResponseEntity getUser()
    {
       try
       {
        return ResponseEntity.ok("Сервер работает");
       }
       catch(Exception e)
       {
        return ResponseEntity.badRequest().body("Произошла ошибка get");
       }
    }
    }