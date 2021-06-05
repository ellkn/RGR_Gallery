package RGR.Gallery.model;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private final String userName;
    private final String password;
}
