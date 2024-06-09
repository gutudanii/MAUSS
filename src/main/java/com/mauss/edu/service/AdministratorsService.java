package com.mauss.edu.service;

import com.mauss.edu.model.Administrators;
import org.springframework.stereotype.Service;

@Service
public interface AdministratorsService {

    void saveAdministrators(Administrators administrators);
    Administrators updates(Administrators administrators, Long id);
    void deleteAdmns(Long id);
}
