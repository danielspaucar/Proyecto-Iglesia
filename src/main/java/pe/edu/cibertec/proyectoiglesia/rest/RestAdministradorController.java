package pe.edu.cibertec.proyectoiglesia.rest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.proyectoiglesia.model.Administrador;
import pe.edu.cibertec.proyectoiglesia.service.IAdministradorService;

import java.util.List;

@RestController
@RequestMapping("api/v1/administrador")
public class RestAdministradorController {
    @Autowired
    private IAdministradorService administradorService;

        @GetMapping
        public ResponseEntity<?> listarAdministrador() {
            List<Administrador> administrador = administradorService.listarAdministrador();
            return new ResponseEntity<>(administrador, administrador.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<?> obtenerAdministrador(@PathVariable("id") Integer id){
            return new ResponseEntity<>(administradorService.obtenerAdministrador(id), HttpStatus.OK);
        }
        @PostMapping
        public ResponseEntity<?> insertar(@Valid @RequestBody Administrador adm){
            Administrador newAdministrador = administradorService.registrarAdministrador(adm);
            return new ResponseEntity<Administrador>(newAdministrador, HttpStatus.OK);
        }

        @PutMapping
        public ResponseEntity<?> modificar(@Valid @RequestBody Administrador adm){
            Administrador newPersona = administradorService.registrarAdministrador(adm);
            return new ResponseEntity<Administrador>(newPersona, HttpStatus.OK);
        }

        @DeleteMapping(value = "/{id}")
        public void eliminar(@PathVariable("id") Integer id){
            administradorService.eliminarAdministrador(id);
        }
}
