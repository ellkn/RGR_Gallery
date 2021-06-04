package RGR.Gallery.service.implementations;

import RGR.Gallery.dao.ConfirmationTokenDao;
import RGR.Gallery.model.ConfirmationToken;
import RGR.Gallery.model.User;
import RGR.Gallery.service.interfaces.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

    @Autowired
    private ConfirmationTokenDao confirmationTokenDao;

    public Optional<ConfirmationToken> getToken(String token) {
        return confirmationTokenDao.findByToken(token);
    }

    public void setConfirmedAt(Long tokenId) {
        confirmationTokenDao.updateConfirmedAt(tokenId, LocalDateTime.now());
    }


    public void saveConfirmationToken(ConfirmationToken token) {

    }

    public String generateToken(User user) {
        String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                user
        );

        confirmationTokenDao.saveConfirmationToken(
                confirmationToken);

        return token;
    }


}
