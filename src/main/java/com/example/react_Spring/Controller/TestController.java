package com.example.react_Spring.Controller;


import com.example.react_Spring.DTO.LoginDTO;
import com.example.react_Spring.DTO.MemberDTO;
import com.example.react_Spring.DTO.TodolistDTO;
import com.example.react_Spring.Domain.Member;
import com.example.react_Spring.Domain.Todolist;
import com.example.react_Spring.Repository.MemberRepository;
import com.example.react_Spring.Repository.TodolistRepository;
import com.example.react_Spring.Service.MemberService;
import com.example.react_Spring.Service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class TestController {

    private final MemberRepository repository;
    private final MemberService memberService;
    private final TodolistService todolistService;
    private final TodolistRepository todolistRepository;
    @Autowired
    public TestController(MemberRepository repository, MemberService memberService, TodolistService todolistService, TodolistRepository todolistRepository) {
        this.repository = repository;
        this.memberService = memberService;
        this.todolistService = todolistService;
        this.todolistRepository = todolistRepository;
    }

    @GetMapping("/")
    public String mainlogin(){
        return "Sign/MainLogin";
    }

    @GetMapping("/sign_up")
    public String GoToSign_Up(){
        return "Sign/sign-up";
    }

    @PostMapping("/sign_up")
    public String Sign_Up(MemberDTO memberDTO){
        Member member = new Member(memberDTO);
        memberService.join(member);
        return "Sign/Success";
    }

    @GetMapping("MainLogin/find_id")
    public String Goto_findId(){
        return "Sign/findId";
    }


    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpServletRequest request,Model model){
        Member member = memberService.Login(memberDTO.getUserId(),memberDTO.getPwd());
        if(member == null) return "redirect:/";

        MemberDTO loginMember = new MemberDTO(member.getId(),member.getUserid(),member.getName(),member.getPwd(),member.getEmail(),member.getSchoolid(),member.getPhone(),member.getLevel());

        HttpSession session = request.getSession();
        session.setAttribute(SessionConstants.Login_Member,loginMember);
        session.setMaxInactiveInterval(1800);

        return "redirect:/AUTH";
    }

    @PostMapping("/Logout")
    public String LogOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

}


