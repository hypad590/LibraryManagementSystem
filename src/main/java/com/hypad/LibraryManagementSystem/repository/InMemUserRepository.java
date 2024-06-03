package com.hypad.LibraryManagementSystem.repository;

import com.hypad.LibraryManagementSystem.model.Book;
import com.hypad.LibraryManagementSystem.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemUserRepository {
    private final List<User> users = new ArrayList<>();

    public List<User> findAllUsers(){return users;}

    public User addUser(User user){
        users.add(user);
        return user;
    }

    public User updateUser(User user){
        if (user == null || user.getName() == null) {
            return null;
        }
        var bookIndex = IntStream.range(0,
                        users.size())
                .filter(index -> users.get(index).getName().equals(user.getName()))
                .findFirst()
                .orElse(-1);
        if(bookIndex > -1){
            users.add(bookIndex, user);
            return user;
        }
        else {
            return null;
        }
    }
    public User findBySurname(
            String surname
             ){
        return users
                .stream()
                .filter(el -> el.getSurName().equals(surname))
                .findFirst().orElse(null);
    }
    public void deleteUserByHisData(
            String name,
            String surname,
            String patronymic){
        var usersData = findBySurname(surname);
        if(usersData != null){
            users.remove(usersData);
        }
    }
}
