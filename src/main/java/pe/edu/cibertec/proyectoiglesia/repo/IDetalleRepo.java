package pe.edu.cibertec.proyectoiglesia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.cibertec.proyectoiglesia.model.Detalle;

public interface IDetalleRepo extends JpaRepository<Detalle,Integer> {
}
