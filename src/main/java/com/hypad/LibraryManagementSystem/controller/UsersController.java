package com.hypad.LibraryManagementSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hypad.LibraryManagementSystem.model.User;
import com.hypad.LibraryManagementSystem.service.UsersService;

import lombok.AllArgsConstructor;

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
    public ResponseEntity<String> registerUser(@RequestBody User user, Model model){
        if(user != null){
            usersService.addUser(user);
            model.addAttribute("user",user);
            System.out.println("User: " + user + "registered successfully");
            return ResponseEntity.ok("User registered successfully");
        }else{
            return ResponseEntity.badRequest().body("Invalid user data");
        }
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

    @DeleteMapping("/deleteUser/{surname}")
    public ResponseEntity<?>  deleteUser(@PathVariable String surname,
                                         String name,
                                         String patronymic){
        try{
            usersService.deleteUserByHisData(name,surname,patronymic);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(500).body("Error deleting user: " + e.getMessage());
        }

    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        return "delete";
    }
}
