package com.mauss.edu.service.impl;

import com.mauss.edu.model.Registrar;
import com.mauss.edu.repository.RegistrarRepository;
import com.mauss.edu.service.RegistrarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegistrarServiceImpl implements RegistrarService {

    @Autowired
    private final RegistrarRepository registrarRepository;
    @Override
    public void saveRegistrar(Registrar registrar) {
        registrarRepository.save(registrar);
    }

    @Override
    public void deleteRegistrarById(Long id) {
        registrarRepository.deleteById(id);
    }

    @Override
    public List<Registrar> getAllRegistrar() {
        return registrarRepository.findAll();
    }
}
