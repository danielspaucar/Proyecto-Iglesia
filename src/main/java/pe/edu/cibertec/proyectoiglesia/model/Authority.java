package pe.edu.cibertec.proyectoiglesia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="authority")
public class Authority {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String authority;
}
