package com.example.react_Spring.Domain;

import com.example.react_Spring.DTO.TodolistDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Todolist")
public class Todolist {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long idx;
    @Column(name = "userid")
    private String userid;
    @Column(name = "todo")
    private String todo;
    @Column(name = "complete")
    private String complete;
    @Column(name = "completedate")
    private String completedate;

    @Builder
    public Todolist(TodolistDTO todolistDTO){
        this.todo = todolistDTO.getTodo();
        this.userid=todolistDTO.getUserid();
        this.complete = todolistDTO.getComplete();
        this.completedate = todolistDTO.getCompleteDate();
    }

}
