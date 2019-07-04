package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;

/**
 * CuposBuildTest
 */
public class CuposBuildCommand {
    private long idCupo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private String tipoVehiculo;
    private int cilindraje;
    private int valor;

    public CuposBuildCommand() {
        this.idCupo = 1;
        this.placa = Constantes.PLACA;
        this.horaEntrada = new Date();
        this.horaSalida = null;
        this.tipoVehiculo = "Carro";
        this.cilindraje = 0;
    }

    public CuposBuildCommand idCupo(long idCupo) {
        this.idCupo = idCupo;
        return this;
    }

    public CuposBuildCommand cilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public CuposBuildCommand placa(String placa) {
        this.placa = placa;
        return this;
    }

    public CuposBuildCommand horaEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public CuposBuildCommand horaSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public CuposBuildCommand tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public RegisterCommand build() {
        return new RegisterCommand(idCupo, placa, horaEntrada, horaSalida, tipoVehiculo, cilindraje, valor);
    }

}