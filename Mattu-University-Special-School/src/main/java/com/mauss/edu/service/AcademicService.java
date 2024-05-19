package com.mauss.edu.service;

import com.mauss.edu.model.Academic;
import org.springframework.stereotype.Service;

@Service
public interface AcademicService {

    void saveAcademic(Academic academic);
}
