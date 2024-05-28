package com.mauss.edu.repository;

import com.mauss.edu.model.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    List<Announcement> getAllByTarget(String target);
    List<Announcement> findByTargetIn(List<String> targets);
    List<Announcement> getAllByAuthorId(String authorId);

}
