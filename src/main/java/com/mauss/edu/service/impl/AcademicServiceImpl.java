package com.mauss.edu.service.impl;

import com.mauss.edu.model.Academic;
import com.mauss.edu.repository.AcademicRepository;
import com.mauss.edu.service.AcademicService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AcademicServiceImpl implements AcademicService {

    @Autowired
    private final AcademicRepository academicRepository;


    @Override
    public Academic end(String acadId) {
        Academic academic = academicRepository.getByAcademicId(acadId).get();
        academic.setEnd(true);
        academicRepository.save(academic);
        return academic;
    }

    @Override
    public Academic notEnd(String acadId) {
        Academic academic = academicRepository.getByAcademicId(acadId).get();
        academic.setEnd(false);
        academicRepository.save(academic);
        return academic;
    }
    @Override
    public void saveAcademic(Academic academic) {
        academic.setAcademicId("ACAD-"+academic.getYear() + "-" + academic.getSemester());
        academicRepository.save(academic);
    }

    @Override
    public void deleteAcademic(Long id) {
        academicRepository.deleteById(id);
    }
}
