package com.mauss.edu.service;

import com.mauss.edu.model.Contact;
import org.springframework.stereotype.Service;

@Service
public interface ContactService {

    void saveContact(Contact contact);
}
