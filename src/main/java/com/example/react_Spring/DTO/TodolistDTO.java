package com.example.react_Spring.DTO;

import lombok.*;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodolistDTO {
    private Long idx;
    private String userid;
    private String todo;
    private String Complete;
    private String CompleteDate;
}
