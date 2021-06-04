package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.User;

public interface UserService {
    void enableUser(Long userId);
    String save(User user);
    User loadUser(Long userId);
}
