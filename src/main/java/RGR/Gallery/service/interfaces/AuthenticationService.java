package com.example.gallery.service.interfaces;

import com.example.gallery.model.User;

import java.io.IOException;

public interface AuthenticationService {
    User login(String login,String password) throws IOException;
    String checkUserCredentials(User user, String password);

}
