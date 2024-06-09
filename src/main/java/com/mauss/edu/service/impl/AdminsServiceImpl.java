package com.mauss.edu.service.impl;

import com.mauss.edu.model.Admins;
import com.mauss.edu.repository.AdminsRepository;
import com.mauss.edu.service.AdminsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminsServiceImpl implements AdminsService {

    @Autowired
    private final AdminsRepository adminsRepository;
    @Override
    public void saveAdmin(Admins admins) {
        adminsRepository.save(admins);
    }

    @Override
    public void deleteAdminById(Long id) {
        adminsRepository.deleteById(id);
    }

    @Override
    public List<Admins> getAllAdmins() {
        return adminsRepository.findAll();
    }

}
