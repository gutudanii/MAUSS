package com.mauss.edu.service;

import com.mauss.edu.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersService {

    void saveUser(Users users);
    void deleteUserById(Long id);
    List<Users> getAllUsers();
}
