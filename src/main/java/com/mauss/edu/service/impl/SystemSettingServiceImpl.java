package com.mauss.edu.service.impl;

import com.mauss.edu.model.SystemSetting;
import com.mauss.edu.repository.SystemSettingRepository;
import com.mauss.edu.service.SystemSettingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SystemSettingServiceImpl implements SystemSettingService {

    @Autowired
    private final SystemSettingRepository systemSettingRepository;
    @Override
    public void saveSystemSettings(SystemSetting systemSetting) {
        systemSettingRepository.save(systemSetting);
    }

    @Override
    public SystemSetting update(SystemSetting systemSetting, Long id) {
        return null;
    }

    @Override
    public void deleteSys(Long id) {
        systemSettingRepository.deleteById(id);
    }
}
