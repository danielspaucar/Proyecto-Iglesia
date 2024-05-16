package pe.edu.cibertec.proyectoiglesia.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectoiglesia.model.Administrador;
import pe.edu.cibertec.proyectoiglesia.repo.IAdministradorRepo;
import pe.edu.cibertec.proyectoiglesia.service.IAdministradorService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdministradorServiceImpl implements IAdministradorService {
    @Autowired
    private IAdministradorRepo administradorRepo;

    public List<Administrador> listarAdministrador() {
        return administradorRepo.findAll();
    }

    public Administrador obtenerAdministrador(Integer id) {
        return administradorRepo.findById(id).get();
    }

    public Administrador registrarAdministrador(Administrador administrador) {
        return administradorRepo.save(administrador);
    }

    public Administrador modificarAdministrador(Administrador administrador) {
        return administradorRepo.save(administrador);
    }

    public String eliminarAdministrador(Integer id) {
        administradorRepo.deleteById(id);
        return "Creyente eliminado";
    }
    public List<Administrador> listar(Administrador a) {
        if ( (a.getNombre()!=null && !a.getNombre().isEmpty()) && (a.getFechaRegistro()==null) && (a.getEvento()==null)) {
            return administradorRepo.findByNombre(a.getNombre());
        } else if ( (a.getFechaRegistro()!=null ) && (a.getNombre()==null || a.getNombre().isEmpty()) && (a.getEvento()==null) ) {
            return administradorRepo.findByFechaRegistro(a.getFechaRegistro());
        } else if ( (a.getEvento()!=null ) && (a.getNombre()==null || a.getNombre().isEmpty()) && (a.getFechaRegistro()==null) ) {
            return administradorRepo.findByEvento(a.getEvento());
        }
        return administradorRepo.findAll();
    }
}
