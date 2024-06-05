package com.hypad.LibraryManagementSystem.controller;

import com.hypad.LibraryManagementSystem.model.User;
import com.hypad.LibraryManagementSystem.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
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

    @GetMapping("/user/{surname}")
    public @ResponseBody User findUser(@PathVariable String surname){
        return usersService.findBySurname(surname);
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody User user, Model model){
        if(user != null){
            usersService.addUser(user);
            model.addAttribute("user",user);
            System.out.println("User: " + user + "registered successfully");
        }
        return "register";
    }
    @GetMapping("/register")
    public String registerUser(){
        return "register";
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user, Model model){
        usersService.updateUser(user);
        model.addAttribute("user",user);
        return "/api/v2";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        return "update";
    }

    //on btn method 🔽 todo
    @DeleteMapping("/deleteUser/{surname}")
    public void deleteUser(@PathVariable String surname, String name,String patronymic){
        usersService.deleteUserByHisData(name,surname,patronymic);
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        return "delete";
    }
}
