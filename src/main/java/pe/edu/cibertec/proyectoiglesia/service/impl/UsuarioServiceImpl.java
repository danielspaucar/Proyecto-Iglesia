package pe.edu.cibertec.proyectoiglesia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectoiglesia.model.Usuario;
import pe.edu.cibertec.proyectoiglesia.repo.IUsuarioRepo;
import pe.edu.cibertec.proyectoiglesia.service.IUsuarioService;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return usuarioRepo.findByUsername(username);
    }
}

