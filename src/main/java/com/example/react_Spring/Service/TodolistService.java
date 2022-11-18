package com.example.react_Spring.Service;

import com.example.react_Spring.DTO.TodolistDTO;
import com.example.react_Spring.Domain.Member;
import com.example.react_Spring.Domain.Todolist;
import com.example.react_Spring.Repository.MemberRepository;
import com.example.react_Spring.Repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TodolistService {
    private final TodolistRepository todolistRepository;
    private final MemberRepository memberRepository;
    @Autowired
    public TodolistService(TodolistRepository todolistRepository, MemberRepository memberRepository) {
        this.todolistRepository = todolistRepository;
        this.memberRepository = memberRepository;
    }

    public Long AddTodolist(TodolistDTO todolistDTO){
        Todolist todolist = new Todolist(todolistDTO);
        todolistRepository.save(todolist);
        return todolist.getIdx();
    }

    public List<Todolist> SendList(Member member){
        return todolistRepository.findByUserid(member.getUserid());
    }

    public void Complete(Todolist todolist) {
        todolistRepository.delete(todolist);
    }

}
