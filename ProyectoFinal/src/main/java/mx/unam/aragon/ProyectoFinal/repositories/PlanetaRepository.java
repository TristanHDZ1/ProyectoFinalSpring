package mx.unam.aragon.ProyectoFinal.repositories;
import mx.unam.aragon.ProyectoFinal.entities.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Integer> {
}