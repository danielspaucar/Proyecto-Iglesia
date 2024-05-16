package pe.edu.cibertec.proyectoiglesia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="evento")
public class Evento {
    @Id
    @GeneratedValue
    @Column(name = "evento_id")
    private int id;

    @Column(name = "evento_nombre")
    private String nombre;
}
