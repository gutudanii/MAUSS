package com.mauss.edu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Table
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uniqueId; //TODO: this unique id is like if the user is student it starts with stud_id ...
    private String fName;
    private String mName;
    private String lName;
    private String dob;
    private String address;
    private Long phone;
    private String email;
    private String username; //TODO: Auto generated
    private String password; //TODO: Auto generated
    private String e_contactFName;
    private Long e_contactPhone;
    private String e_contactAddress;
    private String role; //TODO: Drop-down menu choose from limited roles
    private boolean is_active; //TODO: on first registry it's default input is True
//    private byte[] userPic;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
