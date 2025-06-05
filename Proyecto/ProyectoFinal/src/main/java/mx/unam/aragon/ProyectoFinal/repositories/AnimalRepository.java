package mx.unam.aragon.ProyectoFinal.repositories;

import mx.unam.aragon.ProyectoFinal.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}