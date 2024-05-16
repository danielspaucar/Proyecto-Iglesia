package pe.edu.cibertec.proyectoiglesia.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.cibertec.proyectoiglesia.model.Administrador;
import pe.edu.cibertec.proyectoiglesia.service.IAdministradorService;
import pe.edu.cibertec.proyectoiglesia.service.IDetalleService;
import pe.edu.cibertec.proyectoiglesia.service.IEventoService;

@Controller
@AllArgsConstructor
public class AdministradorController {
    @Autowired
    private IAdministradorService administradorService;

    @Autowired
    private IEventoService eventoService;

    @Autowired
    private IDetalleService detalleService;

    @GetMapping({"/","/login"})
    public String index() {
        return "index";
    }

    @RequestMapping("/administrador")
    public String index(Model model) {
        model.addAttribute("listaEvento", eventoService.listarEvento());
        model.addAttribute("administrador", new Administrador());
        model.addAttribute("lista",administradorService.listarAdministrador());
        return "inicio";
    }

    @RequestMapping("/consultar")
    public String consultar(Administrador administrador, Model model) {
        model.addAttribute("listaEvento", eventoService.listarEvento());
        model.addAttribute("lista", administradorService.listar(administrador));

        return "inicio";
    }

    @GetMapping("/registrar/{id}")
    public String mostrarPersona(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("listEvento", eventoService.listarEvento());
        model.addAttribute("listDetalle", detalleService.listarDetalle());
        if (id != null && id !=0 ) {
            model.addAttribute("administrador", administradorService.obtenerAdministrador(id));
        } else {
            model.addAttribute("administrador", new Administrador());
        }
        return "guardar";
    }

    @PostMapping("/registrar")
    public String registrarModificar(@Valid Administrador administrador, BindingResult result, Model model, RedirectAttributes attribute) {
        if (result.hasErrors()) {
            model.addAttribute("listEvento", eventoService.listarEvento());
            model.addAttribute("listDetalle", detalleService.listarDetalle());
            System.out.println("Existen errores en el formulario");
            return "guardar";
        }
        administradorService.registrarAdministrador(administrador);
        System.out.println("Creyente guardada con éxito!");
        attribute.addFlashAttribute("success", "Creyente guardada con éxito!");
        return "redirect:/administrador";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable("id") Integer id, Model model, RedirectAttributes attribute) {
        administradorService.eliminarAdministrador(id);
        System.out.println("Creyente eliminada con éxito!");
        attribute.addFlashAttribute("warning", "Creyente eliminada con éxito!");
        return "redirect:/administrador";
    }
}

