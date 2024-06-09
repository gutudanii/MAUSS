package com.mauss.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SystemSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String telegram;
    private String facebook;
    private String instagram;
    private String twitter;
    private String school;
    private String phone;
    @Lob
    private byte[] logo;
    private String fileName;
}
