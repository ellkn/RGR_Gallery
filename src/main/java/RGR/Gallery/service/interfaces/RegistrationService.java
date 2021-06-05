package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.RegistrationRequest;

import java.io.IOException;

public interface RegistrationService {
    String register(RegistrationRequest request) throws IOException;
    String confirmToken(String token);
    String buildEmail(String name, String link);
}
