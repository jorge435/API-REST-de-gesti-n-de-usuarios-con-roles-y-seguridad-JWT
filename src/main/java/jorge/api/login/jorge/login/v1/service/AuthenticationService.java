package jorge.api.login.jorge.login.v1.service;

import jorge.api.login.jorge.login.v1.Utils.JWTService;
import jorge.api.login.jorge.login.v1.model.Rol;
import jorge.api.login.jorge.login.v1.model.Usuario;
import jorge.api.login.jorge.login.v1.repository.RolRepository;
import jorge.api.login.jorge.login.v1.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private AuthenticationManager authenticationManager;
    private Long idCliente;

    public AuthenticationResponse registrar(RegisterRequest request){
        Rol rol = rolRepository.findbyNombre("Usuario");
        if(rol == null){
            rol = new Rol();
            rol.setNombre("Usuario");
            rol = rolRepository.save(rol);
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRol(rol);
        usuarioRepository.save(usuario);

        if(usuarioRepository.existsByEmail(request.getEmail())){
            System.out.println("Error: el correo ya existe");
            return new AuthenticationResponse("Error: el correo ya existe");

        }

        var jwtToken = jwtService.generateToken(usuario);
        log.info("token generado -> " + jwtToken);
        log.info("Usuario registrado con éxito: " + usuario.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }

}
