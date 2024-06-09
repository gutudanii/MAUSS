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
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String authorId;
    private String postDateTime;
    private String title;
    @Lob
    private String message;
    private String target; //TODO: is that public announcement or Staff only or Student ... .ect
    @Lob
    private byte[] image;
    private String fileName;
}
