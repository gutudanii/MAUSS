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
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String classId; //todo: Auto generated
    private int classNo;
    private String section;
    private String acaId; //todo: Auto taken from the html page by hidden input type
    private String startDateTime;
    private String endDateTime;
    private boolean end; //todo: First time enabled
}
