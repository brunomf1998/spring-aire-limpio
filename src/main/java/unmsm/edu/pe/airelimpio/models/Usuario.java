package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "usu_nombres")
    @Getter @Setter
    private String nombres;

    @Column(name = "usu_apellidos")
    @Getter @Setter
    private String apellidos;

    @Column(name = "usu_email")
    @Getter @Setter
    private String email;

    @Column(name = "usu_password")
    @Getter @Setter
    private String password;

    @ManyToOne
    @JoinColumn(name = "usu_dis_id")
    @JsonIgnoreProperties({"nombre", "usuarios"})
    @Getter @Setter
    private Distrito distrito;
}
