package mx.unam.aragon.ProyectoFinal.services;


import mx.unam.aragon.ProyectoFinal.entities.Planeta;
import mx.unam.aragon.ProyectoFinal.repositories.PlanetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    // Crear
    public boolean guardarPlaneta(Planeta planeta) {
        Planeta result = planetaRepository.save(planeta);
        return result != null;
    }

    // Leer todos
    public List<Planeta> getAllPlanetas() {
        return planetaRepository.findAll();
    }

    // Leer por ID
    public Planeta getPlaneta(Integer id) {
        return planetaRepository.findById(id).orElse(null);
    }

    // Actualizar
    public boolean updatePlaneta(Integer id, Planeta planetaActualizado) {
        if (planetaRepository.existsById(id)) {
            planetaActualizado.setId(id);
            planetaRepository.save(planetaActualizado);
            return true;
        }
        return false;
    }

    // Eliminar
    public boolean deletePlaneta(Integer id) {
        if (planetaRepository.existsById(id)) {
            planetaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}