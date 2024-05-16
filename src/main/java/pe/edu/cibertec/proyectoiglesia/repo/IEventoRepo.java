package pe.edu.cibertec.proyectoiglesia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoiglesia.model.Evento;

public interface IEventoRepo extends JpaRepository<Evento,Integer> {
}
