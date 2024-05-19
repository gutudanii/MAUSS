package com.mauss.edu.service.impl;

import com.mauss.edu.model.Academic;
import com.mauss.edu.repository.AcademicRepository;
import com.mauss.edu.service.AcademicService;
import lombok.AllArgsConstructor;
import org.hibernate.id.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    private final AcademicRepository academicRepository;

    @Override
    public void saveAcademic(Academic academic) {
        academic.setAcademicId("ACAD-"+academic.getYear() + "/" + academic.getSemester());
        academicRepository.save(academic);
    }
}
