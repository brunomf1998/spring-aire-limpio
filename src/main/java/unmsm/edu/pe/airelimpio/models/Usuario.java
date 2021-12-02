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

    @Column(name = "usu_apellido_paterno")
    @Getter @Setter
    private String apellidoPaterno;

    @Column(name = "usu_apellido_materno")
    @Getter @Setter
    private String apellidoMaterno;

    @Column(name = "usu_email")
    @Getter @Setter
    private String email;

    @Column(name = "usu_password")
    @Getter @Setter
    private String password;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usu_dis_id")
    @JsonIgnoreProperties({"nombre", "codigo", "usuarios"})
    @Getter @Setter
    private Distrito distrito;
}
