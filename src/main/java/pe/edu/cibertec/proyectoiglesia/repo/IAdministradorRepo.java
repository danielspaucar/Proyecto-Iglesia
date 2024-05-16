package pe.edu.cibertec.proyectoiglesia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoiglesia.model.Administrador;
import pe.edu.cibertec.proyectoiglesia.model.Evento;

import java.util.Date;
import java.util.List;

public interface IAdministradorRepo extends JpaRepository<Administrador, Integer> {
    List<Administrador> findByNombre(String nombre);
    List<Administrador> findByFechaRegistro(Date fechaRegistro);
    List<Administrador> findByEvento(Evento evento);
}
