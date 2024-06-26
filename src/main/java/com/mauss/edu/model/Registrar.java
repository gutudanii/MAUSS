package com.mauss.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Registrar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uniqueId;
    private boolean Disabled;
    private String assignedDateTime;
    private String revokeDateTime;
    private String assignedAdminId;

    public void setAssignedDateTime(LocalDateTime assignedDateTime) {
        this.assignedDateTime = DateTimeUtils.formatLocalDateTime(assignedDateTime);
    }

    public LocalDateTime getAssignedDateTimeAsLocalDateTime() {
        return DateTimeUtils.parseToLocalDateTime(assignedDateTime);
    }
}
