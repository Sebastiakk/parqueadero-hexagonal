package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.cupos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.EntityParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.EntityVehiculo;

/**
 * Cupos
 */
@Entity
@Table(name = "cupos")
public class EntityCupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cupo;

    @OneToOne()
    @JoinColumn(name = "vehiculo", unique = true, nullable = false)
    private EntityVehiculo id_vehiculo;

    @ManyToOne()
    @JoinColumn(name = "parqueadero", nullable = false)
    private EntityParqueadero id_parqueadero;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hora_entrada;

    public long getId_cupo() {
        return this.id_cupo;
    }

    public void setId_cupo(long id_cupo) {
        this.id_cupo = id_cupo;
    }

    public EntityVehiculo getId_vehiculo() {
        return this.id_vehiculo;
    }

    public void setId_vehiculo(EntityVehiculo id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public EntityParqueadero getId_parqueadero() {
        return this.id_parqueadero;
    }

    public void setId_parqueadero(EntityParqueadero id_parqueadero) {
        this.id_parqueadero = id_parqueadero;
    }

    public Date getHora_entrada() {
        return this.hora_entrada;
    }

    public void setHora_entrada(Date hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

}