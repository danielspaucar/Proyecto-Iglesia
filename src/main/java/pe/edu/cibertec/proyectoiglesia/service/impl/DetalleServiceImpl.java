package pe.edu.cibertec.proyectoiglesia.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.proyectoiglesia.model.Detalle;
import pe.edu.cibertec.proyectoiglesia.repo.IDetalleRepo;
import pe.edu.cibertec.proyectoiglesia.service.IDetalleService;

import java.util.List;

@Service
@AllArgsConstructor
public class DetalleServiceImpl implements IDetalleService {
    @Autowired
    private IDetalleRepo detalleRepo;
    public List<Detalle> listarDetalle() {
        return detalleRepo.findAll();
    }
}
