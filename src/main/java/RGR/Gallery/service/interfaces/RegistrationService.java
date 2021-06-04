package RGR.Gallery.service.interfaces;

import java.io.IOException;

public interface RegistrationService {
    void register() throws IOException;
    Boolean confirmToken(String token);
    String buildEmail(String name, String link);
}
