package mx.unam.aragon.ProyectoFinal.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "FutbolistasBarcelona")
public class Futbolista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String nombre;

    private String pierna;
    private Integer edad;
    private String descripcion;
    private String imagen;

    public Futbolista() {
    }

    public Futbolista(int id, String nombre, String pierna, Integer edad, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.pierna = pierna;
        this.edad = edad;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPierna() {
        return pierna;
    }

    public void setPierna(String pierna) {
        this.pierna = pierna;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Futbolista futbolista = (Futbolista) o;
        return id == futbolista.id &&
                Objects.equals(nombre, futbolista.nombre) &&
                Objects.equals(pierna, futbolista.pierna) &&
                Objects.equals(edad, futbolista.edad) &&
                Objects.equals(descripcion, futbolista.descripcion) &&
                Objects.equals(imagen, futbolista.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, pierna, edad, descripcion, imagen);
    }

    @Override
    public String toString() {
        return "Futbolista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pierna='" + pierna + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
