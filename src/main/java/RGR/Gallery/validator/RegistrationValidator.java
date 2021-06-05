package RGR.Gallery.validator;

import RGR.Gallery.model.RegistrationRequest;
import RGR.Gallery.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationValidator {

    private final EmailValidator emailValidator;

    public RegistrationValidator(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    public String validate(RegistrationRequest user) {
        List<String> messages = new ArrayList<>();
        if (user.getFirstName() == null) {
            messages.add("First name is required.");
        }
        if (user.getLastName() == null) {
            messages.add("Last name is required.");
        }
        if (user.getPassword() == null) {
            messages.add("Password is required.");
        }
        if (user.getEmail() == null) {
            messages.add("Email is required.");
        }
        /*if (user.getDateOfBirth() == null) {
            messages.add("Date of Birth is required.");
        }*/
        if (!messages.isEmpty()) {
            return String.join(",",messages);
        }
        String emailValidationMessage = emailValidator.validate(user.getEmail());
        if (emailValidationMessage != null) {
            return emailValidationMessage;
        }
        if (messages.isEmpty()) {
            return null;
        }
        return String.join(",",messages);
    }
}
