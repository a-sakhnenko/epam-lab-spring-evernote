package com.epam.lab.spring.khokhliatskii.evernote.dao;

import com.epam.lab.spring.khokhliatskii.evernote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Nullable
    User findOneByEmail(String email);

    @Nullable
    User findOne(int id);


}