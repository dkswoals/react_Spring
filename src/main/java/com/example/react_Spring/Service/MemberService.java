package com.example.react_Spring.Service;

import com.example.react_Spring.Domain.Member;
import com.example.react_Spring.Repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

      private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Long join(Member member){
        validateDuplicateMember(member);
        repository.save(member);
        return member.getId();
    }

    public Member Login(String userid,String pwd){
        return repository.findByUserid(userid)
                .filter(m -> m.getPwd().equals(pwd))
                .orElse(null);
    }

    public void validateDuplicateMember(Member member){
        repository.findByUserid(member.getUserid())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });

    }

    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findId(String name,String email){
        return repository.findByNameAndEmail(name,email);
    }


}
