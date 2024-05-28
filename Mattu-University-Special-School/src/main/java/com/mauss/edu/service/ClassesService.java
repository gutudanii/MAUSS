package com.mauss.edu.service;

import com.mauss.edu.model.Classes;
import org.springframework.stereotype.Service;

@Service
public interface ClassesService {

    void saveClasses(Classes classes);
    Classes end(String acadId);
    Classes notEnd(String acadId);
}
