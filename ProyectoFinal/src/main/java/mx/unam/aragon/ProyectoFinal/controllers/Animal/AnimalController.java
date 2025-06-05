package mx.unam.aragon.ProyectoFinal.controllers.Animal;

import mx.unam.aragon.ProyectoFinal.entities.Animal;
import mx.unam.aragon.ProyectoFinal.repositories.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animales")
public class AnimalController {

    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public String listarAnimales(Model model) {
        model.addAttribute("listaAnimales", animalRepository.findAll());
        return "animales/listaAnimales";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("animal", new Animal());
        return "animales/formAnimales";
    }

    @PostMapping("/guardar")
    public String guardarAnimal(@ModelAttribute Animal animal) {
        animalRepository.save(animal);
        return "redirect:/animales";
    }

    @GetMapping("/editar/{id}")
    public String editarAnimal(@PathVariable Long id, Model model) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("animal", animal);
        return "animales/formAnimales";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
        return "redirect:/animales";
    }
}
