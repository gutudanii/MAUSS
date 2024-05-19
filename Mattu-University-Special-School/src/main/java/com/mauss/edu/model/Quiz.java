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

    private String class_no;
    private String question;
    private String answer;
    private String ch_A;
    private String ch_B;
    private String ch_C;
    private String ch_D;
    private String subject;
    private String stream;
    private String title;
    private String ques_id;
}
