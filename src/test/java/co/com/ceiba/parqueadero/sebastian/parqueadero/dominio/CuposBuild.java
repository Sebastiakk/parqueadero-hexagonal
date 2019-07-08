package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;

/**
 * CuposBuildTest
 */
public class CuposBuild {
    private long idCupo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private String tipoVehiculo;
    private int cilindraje;
    private int valor;

    public CuposBuild() {
        this.idCupo = 1;
        this.placa = Constantes.PLACA;
        this.horaEntrada = new Date();
        this.horaSalida = null;
        this.tipoVehiculo = "Carro";
        this.cilindraje = 0;
    }

    public CuposBuild idCupo(long idCupo) {
        this.idCupo = idCupo;
        return this;
    }

    public CuposBuild cilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public CuposBuild placa(String placa) {
        this.placa = placa;
        return this;
    }

    public CuposBuild horaEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public CuposBuild horaSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public CuposBuild tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public Cupos build() {
        return new Cupos(idCupo, placa, horaEntrada, horaSalida, tipoVehiculo, cilindraje, valor);
    }

}