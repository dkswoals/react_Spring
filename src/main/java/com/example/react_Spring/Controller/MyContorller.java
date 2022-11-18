package com.example.react_Spring.Controller;

import com.example.react_Spring.DTO.testDTO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class MyContorller {

    @CrossOrigin("http://192.168.0.6:3000")
    @GetMapping("/api/hello")
    public String hello(){
        System.out.println("확인");
        return "world";
    }

    @PostMapping("/api/test")
    public String test2(testDTO test){
        System.out.println(test);
        return "입력성공";
    }

}
