package com.mauss.edu.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //done
    private String uniqueId; //done
    private String classId;
    private String primarySchoolName; //done
    private String ministryId;
    private String ministryPoint;
    private String entranceExamId;
    private String formName;
    private Long formPhone;
    private String formAddress;
    private String formEmail;
    private int yearEnrolled;
    private String stream; //done
    @Lob
    private byte[] image; //done
    private String imageName;
}
