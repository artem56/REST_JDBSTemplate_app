package com.example.application_dev.controller;

import com.example.application_dev.Entity.UserEntity;
//import com.example.application_dev.repository.UserRepository;
import com.example.application_dev.Exeptions.UserAlreadyExistExeption;
import com.example.application_dev.Exeptions.UserNotExistExeption;
import com.example.application_dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

//FOR JPA
//    @Autowired
//    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){

        try
        {
            userService.registration(user);
            return ResponseEntity.ok(String.format("Пользователь %s %s успешно сохранён", user.getFirstName(), user.getLastName()));
        }
        catch(UserAlreadyExistExeption e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body("jdbc user insert failed");
        }

    }


       @GetMapping
    public ResponseEntity getUser(@RequestParam Long user_id)
    {
       try
       {
         UserEntity user = userService.getUser(user_id);
        return ResponseEntity.ok(user);
       }
       catch(UserNotExistExeption e)
       {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
       catch(Exception e)
       {
        return ResponseEntity.badRequest().body("Произошла ошибка при получении пользователя с id " + user_id);
       }
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestParam Long user_id)
    {
        try
        {
            userService.removeUser(user_id);
            return ResponseEntity.ok("Пользователь с id " + user_id + " успешно удалён");
        }
        catch(UserNotExistExeption e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().body("Произошла ошибка при удалении пользователя с id " + user_id);
        }
    }
    }