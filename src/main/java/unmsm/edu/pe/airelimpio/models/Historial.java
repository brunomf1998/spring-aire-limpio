package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "his_id")
    @Getter @Setter
    private Integer id;

    @Column(name = "his_medida")
    @Getter @Setter
    private Float medida;

    @Column(name = "his_fecha_medida")
    @Getter @Setter
    private Date fechaMedida;

    @ManyToOne
    @JoinColumn(name = "his_zon_id")
    @JsonIgnoreProperties("historial")
    @Getter @Setter
    private Zona zona;
}
