package mx.unam.aragon.ProyectoFinal.repositories;


import mx.unam.aragon.ProyectoFinal.entities.Tenis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenisRepository extends JpaRepository<Tenis, Long> {
}