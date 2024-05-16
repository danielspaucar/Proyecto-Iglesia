package pe.edu.cibertec.proyectoiglesia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoiglesia.model.Usuario;

import java.util.Optional;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByUsername(String username);
}
