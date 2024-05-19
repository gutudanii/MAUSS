package com.mauss.edu.service;

import com.mauss.edu.model.Admins;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminsService {
    void saveAdmin(Admins admins);
    void deleteAdminById(Long id);
    List<Admins> getAllAdmins();
}
