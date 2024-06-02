package com.hypad.LibraryManagementSystem.service;

import com.hypad.LibraryManagementSystem.model.User;
import com.hypad.LibraryManagementSystem.repository.InMemUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemUsersService implements UsersService{
    private final InMemUserRepository repository;
    @Override
    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    @Override
    public User addUser(User user) {
        return repository.addUser(user);
    }

    @Override
    public User updateUser(User user) {
        return repository.updateUser(user);
    }

    @Override
    public User findByUserNameAndSurnameAndPatronymic(String name, String surname, String patronymic) {
        //todo
        return null;
    }

    @Override
    public User findBySurname(String surname) {
        return repository.findBySurname(surname);
    }

    @Override
    public void deleteUserByHisData(String name, String surname, String patronymic) {
        repository.deleteUserByHisData(name,surname,patronymic);
    }
}
