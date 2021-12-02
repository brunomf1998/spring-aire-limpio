package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sensores")
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sen_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "sen_modelo")
    @Getter @Setter
    private String modelo;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "sensor")
    @JsonIgnore
    @Getter @Setter
    private Zona zona;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sensor")
    @JsonIgnore
    @Getter @Setter
    private Set<Historial> historial;
}
