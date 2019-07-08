package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.cupos;

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
    @Column(nullable = false)
    private String placa;
    @Column(name = "hora_entrada", nullable = false)
    private Date horaEntrada;
    @Column(name = "hora_salida")
    private Date horaSalida;
    @Column(name = "tipo_vehiculo", nullable = false)
    private String tipoVehiculo;
    @Column(name = "cilindraje")
    private int cilindraje;
    @Column(name = "valor")
    private int valor;

}