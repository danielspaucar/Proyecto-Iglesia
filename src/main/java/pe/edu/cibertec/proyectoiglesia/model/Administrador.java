package pe.edu.cibertec.proyectoiglesia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name="administrador")
public class Administrador implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "administrador_id")
    private int id;

    @Column(name = "administrador_nombre")
    @NotEmpty
    @Pattern(regexp="[a-zA-Z]{2,20}")
    private String nombre;

    @Column(name = "administrador_apellidopaterno")
    @NotEmpty
    private String apellidopaterno;

    @Column(name = "administrador_apellidomaterno")
    @NotEmpty
    private String apellidomaterno;

    @Column(name = "administrador_edad")
    @NotEmpty
    private String edad;

    @Column(name = "administrador_dni")
    @NotEmpty
    private String dni;

    @Column(name = "administrador_email")
    @NotEmpty
    @Email
    private String email;

    @Column(name = "administrador_fechaRegistro")
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name="evento_id", nullable = false)
    @NotNull
    private Evento evento;

    @ManyToOne
    @JoinColumn(name="detalle_id", nullable = false)
    @NotNull
    private Detalle detalle;
}
