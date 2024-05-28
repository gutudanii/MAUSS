package com.mauss.edu.service;

import com.mauss.edu.model.SystemSetting;
import org.springframework.stereotype.Service;

@Service
public interface SystemSettingService {

    void saveSystemSettings(SystemSetting systemSetting);
    SystemSetting update(SystemSetting systemSetting, Long id);
    void deleteSys(Long id);
}
