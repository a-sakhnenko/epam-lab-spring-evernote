package com.epam.lab.spring.khokhliatskii.evernote.dao;

import com.epam.lab.spring.khokhliatskii.evernote.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface TagDao extends JpaRepository<Tag, Integer> {

    @Nullable
    Tag findOneByName(String name);



}
