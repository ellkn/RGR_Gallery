package com.example.gallery.service.interfaces;

import com.example.gallery.model.RegistrationRequest;

import java.io.IOException;

public interface RegistrationService {
    String register(RegistrationRequest request) throws IOException;
    String confirmToken(String token);
    String buildEmail(String name, String link);
}
