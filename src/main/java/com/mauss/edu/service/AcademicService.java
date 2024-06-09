package com.mauss.edu.service;

import com.mauss.edu.model.Academic;
import org.springframework.stereotype.Service;

@Service
public interface AcademicService {

    Academic end(String id);
    Academic notEnd(String id);
    void saveAcademic(Academic academic);
    void deleteAcademic(Long id);
}
