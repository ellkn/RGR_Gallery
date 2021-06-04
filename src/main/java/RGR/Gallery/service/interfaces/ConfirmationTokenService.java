package RGR.Gallery.service.interfaces;

import RGR.Gallery.model.ConfirmationToken;
import RGR.Gallery.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmationTokenService {

    Optional<ConfirmationToken> getToken(String token);
    void setConfirmedAt(Long tokenId);
    void saveConfirmationToken(ConfirmationToken token);
    String generateToken(User user);
}
