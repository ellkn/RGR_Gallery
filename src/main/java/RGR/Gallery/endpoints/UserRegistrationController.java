package RGR.Gallery.endpoints;

import RGR.Gallery.service.implementations.RegistrationServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Define an controller for accepting token
 * */
@RestController
public class UserRegistrationController {

    private final RegistrationServiceImpl registrationServiceImpl;

    public UserRegistrationController(RegistrationServiceImpl registrationServiceImpl) {
        this.registrationServiceImpl = registrationServiceImpl;
    }

    @GetMapping(path = "confirm")
    public RedirectView confirm(@RequestParam("token") String token,RedirectAttributes attributes) {
        if (registrationServiceImpl.confirmToken(token)) {
                attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
                return new RedirectView("index.jsf");
        } else {
            return new RedirectView("index.jsf");
        }
    }

}
