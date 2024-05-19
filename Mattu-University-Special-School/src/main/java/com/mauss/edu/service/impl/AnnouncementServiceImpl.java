package com.mauss.edu.service.impl;

import com.mauss.edu.model.Announcement;
import com.mauss.edu.repository.AnnouncementRepository;
import com.mauss.edu.service.AnnouncementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private final AnnouncementRepository announcementRepository;

    @Override
    public void saveAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }
}
