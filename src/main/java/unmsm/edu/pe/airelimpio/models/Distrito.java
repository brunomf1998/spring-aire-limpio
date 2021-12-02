package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "distritos")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dis_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "dis_nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "dis_codigo")
    @Getter @Setter
    private String codigo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "distrito")
    @JsonIgnore
    @Getter @Setter
    private Set<Usuario> usuarios;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "distrito")
    @JsonIgnore
    @Getter @Setter
    private Set<Zona> zonas;
}