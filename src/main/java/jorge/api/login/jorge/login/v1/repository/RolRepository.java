package jorge.api.login.jorge.login.v1.repository;

import jorge.api.login.jorge.login.v1.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
