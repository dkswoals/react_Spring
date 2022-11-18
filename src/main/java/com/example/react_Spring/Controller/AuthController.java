package com.example.react_Spring.Controller;


import com.example.react_Spring.DTO.MemberDTO;
import com.example.react_Spring.DTO.TodolistDTO;
import com.example.react_Spring.Domain.Todolist;
import com.example.react_Spring.Repository.MemberRepository;
import com.example.react_Spring.Repository.TodolistRepository;
import com.example.react_Spring.Service.MemberService;
import com.example.react_Spring.Service.TodolistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequestMapping("/AUTH")
public class AuthController {

     TodolistRepository todolistRepository;
     MemberRepository memberRepository;
     TodolistService todolistService;
     MemberService memberService;

    public AuthController(TodolistRepository todolistRepository, MemberRepository memberRepository, TodolistService todolistService, MemberService memberService) {
        this.todolistRepository = todolistRepository;
        this.memberRepository = memberRepository;
        this.todolistService = todolistService;
        this.memberService = memberService;
    }

    @GetMapping()
    public String MainPage(@SessionAttribute(name = SessionConstants.Login_Member, required = false) MemberDTO memberDTO, Model model){
        List<Todolist> list = todolistRepository.findByUserid(memberDTO.getUserId());
        model.addAttribute("Todo",list);
        return "MainPage/Main";
    }

    @PostMapping("/insert_todo")
    public String AddList(@SessionAttribute(name = SessionConstants.Login_Member, required = false)MemberDTO memberDTO, Model model, TodolistDTO todolistDTO){
        todolistDTO.setUserid(memberDTO.getUserId());
        todolistDTO.setComplete("N");
        todolistService.AddTodolist(todolistDTO);
        return "redirect:/AUTH";
    }

    @PostMapping("/AUTH/Complete")
    public String Complete(@SessionAttribute(name = SessionConstants.Login_Member, required = false)MemberDTO memberDTO, Model model, TodolistDTO todolistDTO){

        return "redirect:/AUTH";
    }


}
