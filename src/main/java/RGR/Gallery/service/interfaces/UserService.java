package com.example.gallery.service.interfaces;

import com.example.gallery.model.RegistrationRequest;
import com.example.gallery.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void enableUser(Long userId);
    String save(RegistrationRequest request);
    User loadUser(Long userId);
}
