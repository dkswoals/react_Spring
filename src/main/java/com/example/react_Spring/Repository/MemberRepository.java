package com.example.react_Spring.Repository;

import com.example.react_Spring.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByUserid(String userid);
    List<Member> findAll();
    Optional<Member> findByNameAndEmail(String Name,String Email);
}
