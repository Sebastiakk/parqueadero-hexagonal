package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * EntityCupos
 */
@Entity
@Table(name = "cupos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

}