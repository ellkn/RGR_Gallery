package com.example.gallery.endpoints;

import com.example.gallery.model.RegistrationRequest;
import com.example.gallery.model.User;
import com.example.gallery.service.implementations.RegistrationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * Define an controller for accepting token
 * */
@RestController
@RequestMapping(path = "api/v1/dashboard")
public class UserRegistrationController {

    private final RegistrationServiceImpl registrationServiceImpl;

    public UserRegistrationController(RegistrationServiceImpl registrationServiceImpl) {
        this.registrationServiceImpl = registrationServiceImpl;
    }

    @PostMapping(path = "/register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationServiceImpl.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationServiceImpl.confirmToken(token);
    }

}
