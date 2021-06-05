package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.RegistrationRequest;
import RGR.Gallery.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void enableUser(Long userId);
    String save(RegistrationRequest request);
    User loadUser(Long userId);
}
