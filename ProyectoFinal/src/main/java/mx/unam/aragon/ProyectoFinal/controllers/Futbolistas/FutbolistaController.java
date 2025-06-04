package mx.unam.aragon.ProyectoFinal.controllers.Futbolistas;

import mx.unam.aragon.ProyectoFinal.entities.Futbolista;
import mx.unam.aragon.ProyectoFinal.services.FutbolistaService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/barca/")
public class FutbolistaController {

    @Autowired
    private FutbolistaService futbolistaService;

    @GetMapping("/principio")
    public String principal(Model model) {
        Futbolista futbolista = new Futbolista();
        return "barca/principio";
    }

    @GetMapping("/equipo")
    public String home(Model model) {
        Futbolista futbolista = new Futbolista();
        model.addAttribute("futbolistaNuevo",futbolista);
        model.addAttribute("futbolista",futbolistaService.getAllFutbolistas());
        return "barca/equipo";
    }

    @GetMapping("/futbolista")
    public String futbolista(Model model) {
        Futbolista futbolista = new Futbolista();
        model.addAttribute("futbolista", futbolista);
        return "barca/futbolista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("futbolista", new Futbolista());
        return "barca/formFutbolista";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Futbolista futbolista) {
        LoggerFactory.getLogger(getClass()).info("Guardando Futbolista: " + futbolista);
        futbolistaService.guardarFutbolista(futbolista);
        return "redirect:/barca/equipo?exito";
    }

    @GetMapping("/futbolista/{id}")
    public String futbolista(@PathVariable Integer id, Model model) {
        model.addAttribute("futbolista", futbolistaService.getFutbolista(id));
        return "barca/futbolista";
    }
    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizar(@PathVariable Integer id, Model model) {
        Futbolista futbolista = futbolistaService.getFutbolista(id);
        model.addAttribute("futbolista", futbolista);
        return "barca/formActualizarFutbolista";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Integer id,
                             @ModelAttribute Futbolista futbolista,
                             Model model) {
        boolean actualizado = futbolistaService.updateFutbolista(id, futbolista);
        if (actualizado) {
            model.addAttribute("futbolista", futbolista);
            return "redirect:/barca/futbolista/{id}?exito"; // o redirige a una página de éxito
        } else {
            model.addAttribute("error", "No se pudo actualizar");
            return "errorPage";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String mostrarFormularioEliminar(@PathVariable Integer id, Model model) {
        Futbolista futbolista = futbolistaService.getFutbolista(id);
        model.addAttribute("futbolista", futbolista);
        return "barca/formEliminarFutbolista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id,
                           @ModelAttribute Futbolista futbolista,
                           Model model){
        boolean eliminado = futbolistaService.deleteFutbolista(id);
        if(eliminado){
            return "redirect:/barca/equipo?eliminado";
        } else {
            return "errorpage";
        }
    }



}
