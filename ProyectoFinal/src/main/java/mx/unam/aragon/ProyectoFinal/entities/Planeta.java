package mx.unam.aragon.ProyectoFinal.entities;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Esta entidad mapea la tabla "Planetas" en tu base de datos.
 * Nota: el nombre de la clase es singular ("Planeta") y el nombre de la tabla es plural.
 */
@Entity
@Table(name = "Planetas")
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "diametro_km")
    private Double diametroKm;

    @Column(name = "masa_kg")
    private Double masaKg;

    @Column(name = "distancia_al_sol_km")
    private Double distanciaAlSolKm;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "url_imagen", length = 255)
    private String imagen; // Aquí guardas la URL o el nombre del archivo de la imagen

    public Planeta() {
    }

    public Planeta(Integer id, String nombre, Double diametroKm, Double masaKg, Double distanciaAlSolKm, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.diametroKm = diametroKm;
        this.masaKg = masaKg;
        this.distanciaAlSolKm = distanciaAlSolKm;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDiametroKm() {
        return diametroKm;
    }

    public void setDiametroKm(Double diametroKm) {
        this.diametroKm = diametroKm;
    }

    public Double getMasaKg() {
        return masaKg;
    }

    public void setMasaKg(Double masaKg) {
        this.masaKg = masaKg;
    }

    public Double getDistanciaAlSolKm() {
        return distanciaAlSolKm;
    }

    public void setDistanciaAlSolKm(Double distanciaAlSolKm) {
        this.distanciaAlSolKm = distanciaAlSolKm;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // equals() y hashCode() basados en 'id' y 'nombre'
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Planeta planeta = (Planeta) o;
        return Objects.equals(id, planeta.id) &&
                Objects.equals(nombre, planeta.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", diametroKm=" + diametroKm +
                ", masaKg=" + masaKg +
                ", distanciaAlSolKm=" + distanciaAlSolKm +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}