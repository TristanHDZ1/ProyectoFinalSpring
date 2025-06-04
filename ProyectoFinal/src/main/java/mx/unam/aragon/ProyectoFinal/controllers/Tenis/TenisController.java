package mx.unam.aragon.ProyectoFinal.controllers.Tenis;
import mx.unam.aragon.ProyectoFinal.entities.Tenis;
import mx.unam.aragon.ProyectoFinal.repositories.TenisRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tenis")
public class TenisController {

    private final TenisRepository tenisRepository;

    public TenisController(TenisRepository tenisRepository) {
        this.tenisRepository = tenisRepository;
    }

    @GetMapping
    public String listarTenis(Model model) {
        model.addAttribute("tenisList", tenisRepository.findAll());
        return "tenis/listatenis";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("tenis", new Tenis());
        return "tenis/formtenis";
    }

    @PostMapping("/guardar")
    public String guardarTenis(@ModelAttribute Tenis tenis) {
        tenisRepository.save(tenis);
        return "redirect:/tenis";
    }

    @GetMapping("/editar/{id}")
    public String editarTenis(@PathVariable Long id, Model model) {
        Tenis tenis = tenisRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("tenis", tenis);
        return "tenis/formtenis";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTenis(@PathVariable Long id) {
        tenisRepository.deleteById(id);
        return "redirect:/tenis";
    }
}