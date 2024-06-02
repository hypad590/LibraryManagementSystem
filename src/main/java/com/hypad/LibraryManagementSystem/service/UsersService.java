package com.hypad.LibraryManagementSystem.service;

import com.hypad.LibraryManagementSystem.model.User;

import java.util.List;

public interface UsersService {
    List<User> findAllUsers();

    User addUser(User user); //for register

    User updateUser(User user);

    User findByUserNameAndSurnameAndPatronymic(
            String name,
            String surname,
            String patronymic
    );
    User findBySurname(
            String surname
    );

    void deleteUserByHisData(
            String name,
            String surname,
            String patronymic
    );
}
