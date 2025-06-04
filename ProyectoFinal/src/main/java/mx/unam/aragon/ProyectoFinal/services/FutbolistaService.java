package mx.unam.aragon.ProyectoFinal.services;

import mx.unam.aragon.ProyectoFinal.entities.Futbolista;
import mx.unam.aragon.ProyectoFinal.repositories.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FutbolistaService {

    @Autowired
    private FutbolistaRepository futbolistaRepository;

    // Crear
    public boolean guardarFutbolista(Futbolista futbolista){
        Futbolista result = futbolistaRepository.save(futbolista);
        return result != null;
    }
    public List<Futbolista> getAllFutbolistas() {
        return futbolistaRepository.findAll();
    }

    // Leer
    public Futbolista getFutbolista(Integer id){
        return futbolistaRepository.findById(id).orElse(null);
    }

    // Actualizar
    public boolean updateFutbolista(Integer id, Futbolista futbolistaActualizado) {
        if (futbolistaRepository.existsById(id)) {
            futbolistaActualizado.setId(id); // asegúrate de mantener el ID
            futbolistaRepository.save(futbolistaActualizado);
            return true;
        }
        return false;
    }

    // Eliminar
    public boolean deleteFutbolista(Integer id) {
        if (futbolistaRepository.existsById(id)) {
            futbolistaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

