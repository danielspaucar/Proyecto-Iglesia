package pe.edu.cibertec.proyectoiglesia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="detalle")
public class Detalle {
    @Id
    @GeneratedValue
    @Column(name = "detalle_id")
    private int id;

    @Column(name = "detalle_nombre")
    private String nombre;
}
