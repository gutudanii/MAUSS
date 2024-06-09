package com.mauss.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String classId;

    private String question;
    private String ch_A;
    private String ch_B;
    private String ch_C;
    private String ch_D;
    private int chose;
    private int answer;

    private String subject;
    private String subjectId;
    private String stream;
    private String description;
    private String title;
    private String authorId; //TODO: AUTO
}
