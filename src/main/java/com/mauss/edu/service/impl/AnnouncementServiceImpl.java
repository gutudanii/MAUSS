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

    @Override
    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id);
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement, Long id) {
        Announcement announcement1 = announcementRepository.findById(id).get();

        announcement1.setTitle(announcement.getTitle());
        announcement1.setMessage(announcement.getMessage());
        announcement1.setTarget(announcement.getTarget());

        announcementRepository.save(announcement1);
        return announcement1;
    }
}
