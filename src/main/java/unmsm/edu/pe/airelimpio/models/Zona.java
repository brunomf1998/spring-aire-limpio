package unmsm.edu.pe.airelimpio.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "zonas")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zon_id")
    private Integer id;

    @Column(name = "zon_coord_x")
    private Double coordX;

    @Column(name = "zon_coord_y")
    private Double coordY;

    @Column(name = "zon_medida")
    private Float medida;

    @Column(name = "zon_fecha_medida")
    private Date fechaMedida;

    @ManyToOne
    @JoinColumn(name = "zon_dis_id")
    @JsonIgnoreProperties("zonas")
    private Distrito distrito;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "zon_sen_id", referencedColumnName = "sen_id")
    private Sensor sensor;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("zona")
    private Set<Historial> historial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
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

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Set<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(Set<Historial> historial) {
        this.historial = historial;
    }
}
