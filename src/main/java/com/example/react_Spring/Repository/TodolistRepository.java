package com.example.react_Spring.Repository;

import com.example.react_Spring.DTO.TodolistDTO;
import com.example.react_Spring.Domain.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodolistRepository extends JpaRepository<Todolist,Long> {
    List<Todolist> findByUserid(String Userid);
}
