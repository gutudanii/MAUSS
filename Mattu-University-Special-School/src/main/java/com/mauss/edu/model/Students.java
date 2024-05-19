package com.mauss.edu.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uniqueId;
    private int grade;
    private String primarySchoolName;
    private String ministryId;
    private String ministryPoint;
    private String entranceExamId;
//  private byte[] mergedFiles;
    private String formName;
    private Long formPhone;
    private String formAddress;
    private String formEmail;
    private int yearEnrolled;
    private String stream;
}
