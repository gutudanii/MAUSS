package com.mauss.edu.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Academic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String academicId; //TODO: Auto Generated
    private int year;
    private int semester;
    private boolean end;
}
