package jorge.api.login.jorge.login.v1.repository;

import jorge.api.login.jorge.login.v1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
