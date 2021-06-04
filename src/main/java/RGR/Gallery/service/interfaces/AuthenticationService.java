package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.User;

import java.io.IOException;

public interface AuthenticationService {
    void login(String login,String password) throws IOException;
    String checkUserCredentials(User user, String password);

}
