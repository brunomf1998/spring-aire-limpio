package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
@Data
public class Historial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "his_id")
    private Integer id;

    @Column(name = "his_medida")
    private Float medida;

    @Column(name = "his_fecha_medida")
    private Date fechaMedida;

    @ManyToOne
    @JoinColumn(name = "his_zon_id")
    @JsonIgnoreProperties("historial")
    private Zona zona;
}
