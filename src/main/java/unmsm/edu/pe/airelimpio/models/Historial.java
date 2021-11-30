package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historial")
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
    @JoinColumn(name = "his_sen_id")
    @JsonIgnoreProperties("historial")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "his_zon_id")
    @JsonIgnoreProperties("historial")
    private Zona zona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getMedida() {
        return medida;
    }

    public void setMedida(Float medida) {
        this.medida = medida;
    }

    public Date getFechaMedida() {
        return fechaMedida;
    }

    public void setFechaMedida(Date fechaMedida) {
        this.fechaMedida = fechaMedida;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}
