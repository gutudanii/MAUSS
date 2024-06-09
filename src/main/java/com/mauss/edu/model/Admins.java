package com.mauss.edu.model;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admins {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uniqueId;
    private String securityQues1;
    private String securityAns1;
    private String securityQues2;
    private String securityAns2;
    private boolean secEnabled;
    private boolean enabled;
    private String assignedDateTime;
    private String revokeDateTime;
    private String expDate;

    public void setAssignedDateTime(LocalDateTime assignedDateTime) {
        this.assignedDateTime = DateTimeUtils.formatLocalDateTime(assignedDateTime);
    }

    public LocalDateTime getAssignedDateTimeAsLocalDateTime() {
        return DateTimeUtils.parseToLocalDateTime(assignedDateTime);
    }

}
