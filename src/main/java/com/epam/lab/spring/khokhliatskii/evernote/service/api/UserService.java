package com.epam.lab.spring.khokhliatskii.evernote.service.api;

import com.epam.lab.spring.khokhliatskii.evernote.model.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    User get(String email);

    List<User> getAll();

    User save(User user);

    void delete(User user);

    boolean isExists(String email);

}
