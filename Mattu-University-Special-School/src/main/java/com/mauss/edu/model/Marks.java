package com.mauss.edu.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double ass_one;
    private double ass_two;
    private double test_exam;
    private double mid_exam;
    private double final_exam;
    private double total_mark;
    private String aca_id;
    private String stud_id;
    private String teach_id;
    private String class_id;
    private String courseCode;
    private boolean app_requested;
    private boolean is_dep_app;
    private boolean is_reg_app;
    private boolean is_done;

}
