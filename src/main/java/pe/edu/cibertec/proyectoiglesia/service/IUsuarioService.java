package pe.edu.cibertec.proyectoiglesia.service;

import pe.edu.cibertec.proyectoiglesia.model.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    public Optional<Usuario> findByUsername(String username);
}
