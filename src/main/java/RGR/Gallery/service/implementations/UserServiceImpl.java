package com.example.gallery.service.implementations;

import com.example.gallery.dao.UserDao;
import com.example.gallery.model.RegistrationRequest;
import com.example.gallery.model.User;
import com.example.gallery.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ConfirmationTokenServiceImpl confirmationTokenServiceImpl;
    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(ConfirmationTokenServiceImpl confirmationTokenServiceImpl, UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.confirmationTokenServiceImpl = confirmationTokenServiceImpl;
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void enableUser(Long userId) {
        userDao.confirmAccount(userId);
    }

    public String save(RegistrationRequest request) {
        String encodedPassword = bCryptPasswordEncoder
                .encode(request.getPassword());
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        if (request.getCity() != null) {
            user.setCity(request.getCity());
        }
        if (request.getDocument() != null) {
            user.setDocument(request.getDocument());
        }
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPassword(encodedPassword);
        Long userId = userDao.addUser(user);
        user.setUserId(userId);

        return confirmationTokenServiceImpl.generateToken(user);
    }

    public User loadUser(Long userId) {
        return userDao.loadUser(userId);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDao.loadUserByEmail(email);
    }
}
