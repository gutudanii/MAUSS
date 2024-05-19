package com.mauss.edu.service;

import com.mauss.edu.model.Registrar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegistrarService {

    void saveRegistrar(Registrar registrar);
    void deleteRegistrarById(Long id);
    List<Registrar> getAllRegistrar();
}
