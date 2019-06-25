package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vehiculo
 */
@Entity
@Table(name = "vehiculo")
public class EntityVehiculo {

    public enum TipoVehiculo {
        Carro, Moto
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_vehiculo;
    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private int cilintraje;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public TipoVehiculo tipo_vehiculo;

    @Column(nullable = false)
    private String propietario;

    public EntityVehiculo(String placa, String modelo, String color, String marca, int cilintraje,
            TipoVehiculo tipo_vehiculo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.cilintraje = cilintraje;
        this.tipo_vehiculo = tipo_vehiculo;
        this.propietario = propietario;
    }

    public EntityVehiculo() {
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getPropietario() {
        return propietario;
    }

    public long getId_vehiculo() {
        return this.id_vehiculo;
    }

    public void setId_vehiculo(long id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCilintraje() {
        return this.cilintraje;
    }

    public void setCilintraje(int cilintraje) {
        this.cilintraje = cilintraje;
    }

    public TipoVehiculo getTipo_vehiculo() {
        return this.tipo_vehiculo;
    }

    public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }
}