package com.mauss.edu.service.impl;

import com.mauss.edu.mail.MailService;
import com.mauss.edu.model.Contact;
import com.mauss.edu.repository.ContactRepository;
import com.mauss.edu.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private final ContactRepository contactRepository;
    @Autowired
    private final MailService mailService;
    @Override
    public void saveContact(Contact contact) {
        mailService.sendNotification(contact.getSubject(), contact.getMessage(),contact.getFullName(),contact.getEmail());
        contactRepository.save(contact);
    }
}
