package com.hypad.LibraryManagementSystem.controller;

import com.hypad.LibraryManagementSystem.model.User;
import com.hypad.LibraryManagementSystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
public class UsersController {
    private final UsersService usersService;

    //users.html
    @GetMapping
    public String findAllUsers(Model model){
        model.addAttribute("users", usersService.findAllUsers());
        return "users";
    }

    //todo
    @GetMapping("/user/{surname}")
    public User findUser(@PathVariable String surname){return usersService.findBySurname(surname);}

    //method post action /register in register.html
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        if(user != null){
            usersService.addUser(user);
            System.out.println("User: " + user + "registered successfully");
        }
        return "register";
    }

    @PutMapping("/updateUserInfo")
    public String updateUser(@RequestBody User user, Model model){
        usersService.updateUser(user);
        model.addAttribute("user",user);
        return "redirect:/api/v2";
    }

    //method put action /updateUserInfo in update.html
    @GetMapping("/updateUser")
    public String updateUser(){
        return "update";
    }

    @DeleteMapping("/deleteUser/{surname}")
    public void deleteUser(@PathVariable String surname, String name,String patronymic){
        usersService.deleteUserByHisData(name,surname,patronymic);
    }

    //method delete action /deleteUser/{surname} in delete.html
    @GetMapping("/deleteUser")
    public String deleteUser(){
        return "delete";
    }
}
