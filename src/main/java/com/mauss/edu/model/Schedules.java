package com.mauss.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String schId; //todo: this is auto generated like ScheduleId
    private String acaId; //todo: Academic ID
    private String teachName;
    private String classId; //todo: class Id
    private String schedulerId; //todo: the scheduled person id
    private String courseId; //todo: course Id from courses classes
    private String courseName;
    private String schType; //todo: Schedules type may be like special schedules // like may be temporary or tutorial or any
    private String dayOfWeek; //todo: Monday ... Tuesday
    private String startTime;
    private String endTime;
    private String teachId; //todo: Assigned Teacher Id
}
