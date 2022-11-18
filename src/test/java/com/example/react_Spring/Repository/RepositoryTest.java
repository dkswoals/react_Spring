package com.example.react_Spring.Repository;


import com.example.react_Spring.DTO.MemberDTO;
import com.example.react_Spring.Domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    //@After
    public void cleanup(){
        memberRepository.deleteAll();
    }

    @Test
    public void 맴버_저장_확인(){
    }


}
