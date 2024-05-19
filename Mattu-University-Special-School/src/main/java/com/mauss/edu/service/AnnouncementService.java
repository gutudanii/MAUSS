package com.mauss.edu.service;

import com.mauss.edu.model.Announcement;
import org.springframework.stereotype.Service;

@Service
public interface AnnouncementService {

    void saveAnnouncement(Announcement announcement);
}
