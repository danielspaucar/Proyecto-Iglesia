package pe.edu.cibertec.proyectoiglesia.service;

import pe.edu.cibertec.proyectoiglesia.model.Administrador;

import java.util.List;

public interface IAdministradorService {
    public List<Administrador> listarAdministrador();
    public Administrador obtenerAdministrador(Integer id);
    public Administrador registrarAdministrador(Administrador administrador);
    public Administrador modificarAdministrador(Administrador administrador);
    public String eliminarAdministrador(Integer id);
    public List<Administrador> listar(Administrador a);
}
