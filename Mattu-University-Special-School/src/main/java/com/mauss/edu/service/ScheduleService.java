package com.mauss.edu.service;

import com.mauss.edu.model.Schedules;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService{

    void saveSchedule(Schedules schedules);
}
