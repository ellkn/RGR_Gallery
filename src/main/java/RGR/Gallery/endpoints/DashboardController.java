package com.example.gallery.endpoints;

import com.example.gallery.model.Dashboard;
import com.example.gallery.model.LoginRequest;
import com.example.gallery.model.User;
import com.example.gallery.service.implementations.AuthenticationServiceImpl;
import com.example.gallery.service.implementations.DashboardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/dashboard")
public class DashboardController {

    private final DashboardServiceImpl dashboardService;
    private final AuthenticationServiceImpl authenticationService;

    public DashboardController(DashboardServiceImpl dashboardService, AuthenticationServiceImpl authenticationService) {
        this.dashboardService = dashboardService;
        this.authenticationService = authenticationService;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<Dashboard> register(@RequestBody LoginRequest request) {
        User user = authenticationService.login(request.getUserName(),request.getPassword());
        if (user != null) {
            return new ResponseEntity<>(dashboardService.init(user.getUserId()), HttpStatus.OK);
        } else {
            throw new UsernameNotFoundException("Username or password is invalid.");
        }

    }
}