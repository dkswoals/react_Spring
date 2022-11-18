package com.example.react_Spring.Domain;

import com.example.react_Spring.DTO.MemberDTO;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@Table(name = "Member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "userid")
    private String userid;
    @Column(name = "name")
    private String name;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "email")
    private String email;
    @Column(name = "schoolid")
    private String schoolid;
    @Column(name = "phone")
    private String phone;
    @Column(name = "level")
    private int level;

    @Builder
    public Member(MemberDTO memberDTO){
        this.userid = memberDTO.getUserId();
        this.name = memberDTO.getName();
        this.pwd = memberDTO.getPwd();
        this.email = memberDTO.getEmail();
        this.schoolid = memberDTO.getSchoolId();
        this.phone = memberDTO.getPhone();
        this.level = memberDTO.getLevel();
    }

}