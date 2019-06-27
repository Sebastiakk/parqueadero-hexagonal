package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EntityCupos
 */
@Entity
@Table(name = "cupos")
public class EntityCupos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cupo")
    private long idCupo;
    @Column
    private String placa;
    @Column(name = "hora_entrada")
    private Date horaEntrada;
    @Column(name = "hora_salida")
    private Date horaSalida;
    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    public EntityCupos() {
    }

    public EntityCupos(long idCupo, String placa, Date horaEntrada, Date horaSalida, String tipoVehiculo) {
        this.idCupo = idCupo;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoVehiculo = tipoVehiculo;
    }

    public long getIdCupo() {
        return this.idCupo;
    }

    public void setIdCupo(long idCupo) {
        this.idCupo = idCupo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getHoraEntrada() {
        return this.horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getTipoVehiculo() {
        return this.tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}