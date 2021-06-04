package RGR.Gallery.service.implementations;

import RGR.Gallery.dao.UserDao;
import RGR.Gallery.model.User;
import RGR.Gallery.service.interfaces.UserService;
import RGR.Gallery.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ConfirmationTokenServiceImpl confirmationTokenServiceImpl;
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(ConfirmationTokenServiceImpl confirmationTokenServiceImpl, UserDao userDao) {
        this.confirmationTokenServiceImpl = confirmationTokenServiceImpl;
        this.userDao = userDao;
    }

    public void enableUser(Long userId) {
        userDao.confirmAccount(userId);
    }

    public String save(User user) {
        String password = PasswordEncoder.encodePassword(user.getPassword());
        user.setPassword(password);
        Long userId = userDao.addUser(user);
        user.setUserId(userId);

        return confirmationTokenServiceImpl.generateToken(user);
    }

    public User loadUser(Long userId) {
        return userDao.loadUser(userId);
    }


}
