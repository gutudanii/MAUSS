package com.mauss.edu.service.impl;

import com.mauss.edu.model.Students;
import com.mauss.edu.repository.ClassesRepository;
import com.mauss.edu.repository.StudentsRepository;
import com.mauss.edu.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private final StudentsRepository studentsRepository;
    @Autowired
    private final ClassesRepository classesRepository;

    @Override
    public void saveStudent(Students students) {
        studentsRepository.save(students);
    }

    public void assignClass(){
        studentsRepository.findAll();
    }
    @Override
    public void deleteStudentById(Long id) {
        studentsRepository.deleteById(id);
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public Students updateStudents(Students students, String uniqueId) {
        Students students1 = studentsRepository.findByUniqueId(uniqueId).get();
                students1.setClassId(students.getClassId());
                students1.setPrimarySchoolName(students.getPrimarySchoolName());
                students1.setMinistryId(students.getMinistryId());
                students1.setMinistryPoint(students.getMinistryPoint());
                students1.setEntranceExamId(students.getEntranceExamId());
                students1.setFormName(students.getFormName());
                students1.setFormPhone(students.getFormPhone());
                students1.setFormAddress(students.getFormAddress());
                students1.setFormEmail(students.getFormEmail());
                students1.setYearEnrolled(students.getYearEnrolled());
                students1.setStream(students.getStream());
                students1.setImage(students.getImage());
                students1.setImageName(students.getImageName());
        studentsRepository.save(students1);
        return students1;
    }
}
