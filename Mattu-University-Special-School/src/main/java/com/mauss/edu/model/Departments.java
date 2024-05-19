package com.mauss.edu.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String teachName;//todo: Auto Taken from HTML
    private String uniqueId; //todo: Auto Taken from the users nameList
    private String assignedDateTime; //todo: Auto
    private String positionExp; //todo: Auto
    private String revokeDateTime; //todo: Auto
    private boolean Disabled;
    private boolean isReplacement;
    private String replacementExp;
    private boolean isReplacementApp;
    private String assignedRegId;
    private String replacedAppId;

    public void setAssignedDateTime(LocalDateTime assignedDateTime) {
        this.assignedDateTime = DateTimeUtils.formatLocalDateTime(assignedDateTime);
    }

    public LocalDateTime getAssignedDateTimeAsLocalDateTime() {
        return DateTimeUtils.parseToLocalDateTime(assignedDateTime);
    }
}
