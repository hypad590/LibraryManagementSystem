package com.hypad.LibraryManagementSystem.controller;

import com.hypad.LibraryManagementSystem.model.User;
import com.hypad.LibraryManagementSystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping
    public List<User> findAllUsers(){return usersService.findAllUsers();}

    @GetMapping("/user/{surname}")
    public User findUser(@PathVariable String surname){return usersService.findBySurname(surname);}

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        usersService.addUser(user);
        return "User: " + user + "registered successfully";
    }

    @PutMapping("/updateUserInfo")
    public User updateUser(@RequestBody User user){return usersService.updateUser(user);}

    @DeleteMapping("/deleteUser/{surname}")
    public void deleteUser(@PathVariable String surname, String name,String patronymic){
        usersService.deleteUserByHisData(name,surname,patronymic);
    }
}
