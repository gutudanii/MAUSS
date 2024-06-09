package com.mauss.edu.service.impl;

import com.mauss.edu.model.Administrators;
import com.mauss.edu.repository.AdministratorsRepository;
import com.mauss.edu.repository.AdminsRepository;
import com.mauss.edu.service.AdministratorsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdministratorsServiceImpl implements AdministratorsService {

    @Autowired
    private final AdministratorsRepository administratorsRepository;

    @Override
    public void saveAdministrators(Administrators administrators) {
        administratorsRepository.save(administrators);
    }

    @Override
    public Administrators updates(Administrators administrators, Long id) {
        return null;
    }

    @Override
    public void deleteAdmns(Long id) {
        administratorsRepository.deleteById(id);
    }
}
