package RGR.Gallery.service.implementations;

import RGR.Gallery.constants.AppSpecConstants;
import RGR.Gallery.dao.AuthenticationDao;
import RGR.Gallery.model.User;
import RGR.Gallery.dao.UserDao;
import RGR.Gallery.service.interfaces.AuthenticationService;
import RGR.Gallery.utils.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final DashboardServiceImpl dashboardServiceImpl;
    private final UserDao userDao;
    private User user = new User();
    private final AuthenticationDao authenticationDao;
    private Boolean hasValidationMessage = false;
    private String validationMessage;

    public AuthenticationServiceImpl(DashboardServiceImpl dashboardServiceImpl, UserDao userDao, AuthenticationDao authenticationDao) {
        this.dashboardServiceImpl = dashboardServiceImpl;
        this.userDao = userDao;
        this.authenticationDao = authenticationDao;
    }

    public User login(String login,String password) {
        //TODO check user credentials
        //TODO validation
        //User user = authenticationDao.loadUserInfo(login);
        /*String validationMessage = checkUserCredentials(user,password);
        if (validationMessage.equals(AppSpecConstants.OK)) {
            dashboardServiceImpl.init(user.getUserId());
            //FacesContext.getCurrentInstance().getExternalContext().redirect("dashboard.jsf");
        } else {
            hasValidationMessage = true;
            this.validationMessage = validationMessage;

        }*/
        return authenticationDao.loadUserInfo(login);
    }

    public String checkUserCredentials(User user,String password) {
        if (user == null) {
            return "User credentials are invalid";
        } else {
            if (user.getPassword().equals(PasswordEncoder.encodePassword(password))) {
                return AppSpecConstants.OK;
            } else {
                return "User credentials are invalid";
            }
        }

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Boolean getHasValidationMessage() {
        return hasValidationMessage;
    }

    public void setHasValidationMessage(Boolean hasValidationMessage) {
        this.hasValidationMessage = hasValidationMessage;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }
}
