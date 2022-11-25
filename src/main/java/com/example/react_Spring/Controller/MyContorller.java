package com.example.react_Spring.Controller;

import com.example.react_Spring.DTO.MemberDTO;
import com.example.react_Spring.DTO.testDTO;
import com.example.react_Spring.Domain.Member;
import com.example.react_Spring.Repository.MemberRepository;
import com.example.react_Spring.Repository.TodolistRepository;
import com.example.react_Spring.Service.MemberService;
import com.example.react_Spring.Service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController()
public class MyContorller{
    private final MemberRepository repository;
    private final MemberService memberService;
    private final TodolistService todolistService;
    private final TodolistRepository todolistRepository;
    @Autowired
    public MyContorller(MemberRepository repository, MemberService memberService, TodolistService todolistService, TodolistRepository todolistRepository) {
        this.repository = repository;
        this.memberService = memberService;
        this.todolistService = todolistService;
        this.todolistRepository = todolistRepository;
    }

    @PostMapping("/api/sign-up")
    public String Sign_Up(@RequestBody MemberDTO memberDTO){
        Member member = new Member(memberDTO);
        try {
            memberService.join(member);
        }catch (Exception e){
            return "회원가입 실패";
        }
        return "회원가입 성공!!";
    }

    @PostMapping("/login")
    public String login(MemberDTO memberDTO, HttpServletRequest request, Model model){
        Member member = memberService.Login(memberDTO.getUserId(),memberDTO.getPwd());
        if(member == null) return "로그인 실패";

        MemberDTO loginMember = new MemberDTO(member);
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

    @PostMapping("/api/find-id")
    public String FindId(@RequestBody MemberDTO memberDTO){

        System.out.println(memberDTO);

        MemberDTO result = new MemberDTO(memberService.findId(memberDTO.getName(), memberDTO.getEmail()));
        if(result == null) return "결과가 없습니다";

        return result.getUserId();
    }

}
