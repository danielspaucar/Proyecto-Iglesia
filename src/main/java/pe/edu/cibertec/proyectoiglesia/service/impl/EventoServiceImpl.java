package pe.edu.cibertec.proyectoiglesia.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectoiglesia.model.Evento;
import pe.edu.cibertec.proyectoiglesia.repo.IEventoRepo;
import pe.edu.cibertec.proyectoiglesia.service.IEventoService;

import java.util.List;

@Service
@AllArgsConstructor
public class EventoServiceImpl implements IEventoService {
    @Autowired
    private IEventoRepo eventoRepo;

    public List<Evento> listarEvento() {
        return eventoRepo.findAll();
    }
}