package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usu_id")
    private Integer id;

    @Column(name = "usu_nombres")
    private String nombres;

    @Column(name = "usu_apellidos")
    private String apellidos;

    @Column(name = "usu_email")
    private String email;

    @Column(name = "usu_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "usu_dis_id")
    @JsonIgnoreProperties({"nombre", "usuarios"})
    private Distrito distrito;
}
