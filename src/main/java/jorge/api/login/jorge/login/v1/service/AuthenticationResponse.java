package jorge.api.login.jorge.login.v1.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private Long id;
    private String token;
    private String mensaje;

    public AuthenticationResponse(String mensaje) {
        this.mensaje = mensaje;
    }
}
