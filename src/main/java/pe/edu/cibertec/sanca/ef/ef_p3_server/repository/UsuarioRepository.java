package pe.edu.cibertec.sanca.ef.ef_p3_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.sanca.ef.ef_p3_server.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCodigo(String codigo);
}
