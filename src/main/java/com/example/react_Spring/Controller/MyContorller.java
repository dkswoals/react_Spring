package com.example.react_Spring.Controller;

import com.example.react_Spring.DTO.MemberDTO;
import com.example.react_Spring.DTO.testDTO;
import com.example.react_Spring.Domain.Member;
import com.example.react_Spring.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
public class MyContorller {

    MemberService memberService;
   public MyContorller(MemberService memberService){
       this.memberService = memberService;
   }

    @CrossOrigin("http://192.168.0.6:3000")
    @GetMapping("/api/hello")
    public void hello(){
        System.out.println("확인");
    }


    @CrossOrigin
    @PostMapping("/api/test")
    public void test2(@RequestBody testDTO test){
       System.out.println(test);
    }

    @PostMapping("/api/sign-up")
    public MemberDTO Sign_Up(@RequestBody MemberDTO memberDTO){
       Member member = new Member(memberDTO);
       memberService.join(member);
       System.out.println(memberDTO);
        System.out.println(member);
        return memberDTO;
    }





}
