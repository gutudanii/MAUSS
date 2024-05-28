package com.mauss.edu.service.impl;

import com.mauss.edu.mail.Mail;
import com.mauss.edu.mail.MailService;
import com.mauss.edu.model.*;
import com.mauss.edu.repository.*;
import com.mauss.edu.security.PasswordConfig;
import com.mauss.edu.service.*;
import com.mauss.edu.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    @Autowired
    private final MailService mailService;

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final TeachersRepository teachersService;
    @Autowired
    private final StudentsRepository studentsService;
    @Autowired
    private final AdminsRepository adminsService;
    @Autowired
    private final RegistrarRepository registrarService;
    @Override
    public void saveUser(Users users) {
        String userIdGen =  uniqueIdGenerator(users.getRole());
        users.setUniqueId(userIdGen);
        users.setUsername(
                usernameGenerator(
                                users.getFName(),
                                users.getMName(),
                                users.getLName()));
        Random random = new Random();
        users.setPassword(users.getUsername()+random.nextInt(1,1000));
        System.out.println("Username: " + users.getUsername());
        System.out.println("Password: " + users.getPassword());

        Mail mail = new Mail();
        mail.setEmail(users.getEmail());
        mail.setFName(users.getFName());

        mailService.sendMail(mail, users.getUsername(), users.getPassword());
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        users.set_active(true);
        if(users.getRole().equals("admin")){
            Admins admins = new Admins();
            admins.setUniqueId(users.getUniqueId());
            admins.setSecEnabled(false);
            admins.setEnabled(true);
            adminsService.save(admins);
        }
        else if(users.getRole().equals("registrar")){
            Registrar registrar = new Registrar();
            registrar.setUniqueId(users.getUniqueId());
            registrar.setDisabled(false);
            registrarService.save(registrar);
        }
        else if(users.getRole().equals("teacher")){
            Teachers teachers = new Teachers();
            teachers.setUniqueId(users.getUniqueId());
            teachersService.save(teachers);
        }
        else if(users.getRole().equals("student")){
            Students students = new Students();
            students.setUniqueId(users.getUniqueId());
            studentsService.save(students);
        }
        usersRepository.save(users);

    }
    @Override
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }
    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users updateUser(String uniqueId, Users users) {
        Users users1 = usersRepository.findByUniqueId(uniqueId).get();
        users1.setFName(users.getFName());
        users1.setMName(users.getMName());
        users1.setLName(users.getLName());
        users1.setDob(users.getDob());
        users1.setAddress(users.getAddress());
        users1.setPhone(users.getPhone());
        users1.setGender(users.getGender());
        users1.setEmail(users.getEmail());
        users1.setRole(users.getRole());
        usersRepository.save(users1);
        return users1;
    }
    String uniqueIdGenerator(String role){
        String unique_id = null;
        long count = getAllUsers().size()+10;

        if(role.equals("admin")){
            String gnr = String.valueOf(count+1);
            unique_id = "ADM-"+ gnr + "-"+ Year.now();
        }
        else if(role.equals("registrar")){
            String gnr = String.valueOf(count+2);
            unique_id = "REG-"+ gnr + "-"+ Year.now();
        }
        else if(role.equals("teacher")){
            String gnr = String.valueOf(count+3);
            unique_id = "TEACH-"+ gnr + "-"+ Year.now();
        }
        else if(role.equals("student")){
            String gnr = String.valueOf(count+4);
            unique_id = "STU-"+ gnr + "-"+ Year.now();
        }
        return unique_id;
    }
    String usernameGenerator(String fName, String lName, String sName){
        int count = getAllUsers().size();

        int fLen = fName.length();
        int lLen = lName.length();
        int sLen = sName.length();

        return fName.substring(0,fLen/2)
                + lName.substring(0,lLen/2)
                + sName.substring(0,sLen/2)
                + count+2;
    }
}

