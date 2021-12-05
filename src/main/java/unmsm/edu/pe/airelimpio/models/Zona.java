package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zonas")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zon_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "zon_coord_x")
    @Getter @Setter
    private Double coordX;


    @Column(name = "zon_coord_y")
    @Getter @Setter
    private Double coordY;

    @OneToOne
    @JoinColumn(name = "zon_sen_id")
    @JsonIgnoreProperties("modelo")
    @Getter @Setter
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "zon_dis_id")
    @JsonIgnoreProperties({"nombre", "usuarios", "zonas"})
    @Getter @Setter
    private Distrito distrito;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zona")
    @JsonIgnore
    @Getter @Setter
    private Set<Historial> historial;
}