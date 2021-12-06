package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zonas")
@Data
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zon_id")
    private Integer id;

    @Column(name = "zon_coord_x")
    private Double coordX;

    @Column(name = "zon_coord_y")
    private Double coordY;

    @OneToOne
    @JoinColumn(name = "zon_sen_id")
    @JsonIgnoreProperties("modelo")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "zon_dis_id")
    @JsonIgnoreProperties({"nombre", "usuarios", "zonas"})
    private Distrito distrito;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "zona")
    @JsonIgnore
    private Set<Historial> historial;
}