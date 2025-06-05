package mx.unam.aragon.ProyectoFinal.controllers;

import mx.unam.aragon.ProyectoFinal.entities.Planeta;
import mx.unam.aragon.ProyectoFinal.service.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
@RequestMapping("/home/")
public class PlanetasController {

    @Autowired
    private PlanetaService planetaService;

    // --------------------------------------------
    // Vistas generales (Principal y Planetas)
    // --------------------------------------------

    @GetMapping("/Principal/")
    public String Principal() {
        return "Planetas/Principal";
    }

    @GetMapping("/Planetas/")
    public String Planetas() {
        return "Planetas/Planetas";
    }

    // --------------------------------------------
    // CRUD para TablaPlanetas
    // --------------------------------------------

    // 1) Mostrar lista de planetas
    @GetMapping("/TablaPlanetas/")
    public String TablaPlanetas(Model model) {
        List<Planeta> lista = planetaService.getAllPlanetas();
        model.addAttribute("planetas", lista);
        return "Planetas/TablaPlanetas";
    }

    // 2) Mostrar formulario para crear un nuevo planeta
    @GetMapping("/TablaPlanetas/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("planeta", new Planeta());
        return "Planetas/nuevo";
    }

    // 3) Guardar el planeta recién creado
    @PostMapping("/TablaPlanetas/guardar")
    public String guardarPlaneta(@ModelAttribute("planeta") Planeta planeta) {
        planetaService.guardarPlaneta(planeta);
        return "redirect:/home/TablaPlanetas/";
    }

    // 4) Mostrar formulario para editar un planeta existente
    @GetMapping("/TablaPlanetas/editar/{id}")
    public String editarPlaneta(@PathVariable("id") Integer id, Model model) {
        Planeta planetaExistente = planetaService.getPlaneta(id);
        model.addAttribute("planeta", planetaExistente);
        return "Planetas/nuevo"; 
    }

    // 5) Actualizar el planeta con datos modificados (POST)
    @PostMapping("/TablaPlanetas/actualizar/{id}")
    public String actualizarPlaneta(
            @PathVariable("id") Integer id,
            @ModelAttribute("planeta") Planeta planetaActualizado
    ) {
        // ————— FORZAR EL ID AQUÍ —————
        planetaActualizado.setId(id);
        // ————————————————
        planetaService.updatePlaneta(id, planetaActualizado);
        return "redirect:/home/TablaPlanetas/";
    }

    // 6) Eliminar un planeta por su ID (POST)
    @PostMapping("/TablaPlanetas/eliminar/{id}")
    public String eliminarPlaneta(@PathVariable("id") Integer id) {
        planetaService.deletePlaneta(id);
        return "redirect:/home/TablaPlanetas/";
    }
}