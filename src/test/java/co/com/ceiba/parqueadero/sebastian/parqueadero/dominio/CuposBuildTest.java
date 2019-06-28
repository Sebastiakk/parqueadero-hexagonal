package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;

/**
 * CuposBuildTest
 */
public class CuposBuildTest {
    private long idCupo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private String tipoVehiculo;
    private int cilindraje;

    public CuposBuildTest() {
        this.idCupo = 1;
        this.placa = "SEB-123";
        this.horaEntrada = new Date();
        this.horaSalida = new Date();
        this.tipoVehiculo = "Carro";
        this.cilindraje = 150;
    }

    public CuposBuildTest idCupo(long idCupo) {
        this.idCupo = idCupo;
        return this;
    }

    public CuposBuildTest cilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
        return this;
    }

    public CuposBuildTest placa(String placa) {
        this.placa = placa;
        return this;
    }

    public CuposBuildTest horaEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
        return this;
    }

    public CuposBuildTest horaSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
        return this;
    }

    public CuposBuildTest tipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public ModelCupos build() {
        return new ModelCupos(idCupo, placa, horaEntrada, horaSalida, tipoVehiculo, cilindraje);
    }

}