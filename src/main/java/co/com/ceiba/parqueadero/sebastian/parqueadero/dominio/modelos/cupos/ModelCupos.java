package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import lombok.Getter;
import lombok.Setter;

/**
 * Cupos
 */

@Getter
@Setter

public class ModelCupos {

    private long idCupo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private String tipoVehiculo;
    private int cilindraje;
    private int valor;

    public ModelCupos() {
    }

    public ModelCupos(long idCupo, String placa, Date horaEntrada, Date horaSalida, String tipoVehiculo, int cilindraje,
            int valor) {
        this.validarArgumentos(placa, horaEntrada, tipoVehiculo, cilindraje);
        this.idCupo = idCupo;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindraje = cilindraje;
        this.valor = valor;
    }

    private void validarArgumentos(String placa, Date horaEntrada, String tipoVehiculo, int cilindraje) {
        // Valida que la plata este en la data
        ValidarArgumentos.exeptionRequired(placa, Constantes.REQUIRED_PLACA);
        // Valida que el tipo de vehiculo este en la data
        ValidarArgumentos.exeptionRequired(tipoVehiculo, Constantes.REQUIRED_TIPO_VEHICULO);
        // Valida que el tipo de vehiculo sea correcto "Moto" o "Carro"
        ValidarArgumentos.exeptionTipoVehiculo(tipoVehiculo, Constantes.TIPOS_VEHICULO);

        // Si el tipo de vehiculo es moto valida que el cilindraje sea diferente de cero
        if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_MOTO)) {
            ValidarArgumentos.exeptionDiferenteCero(cilindraje, Constantes.REQUIRED_CILINDRAJE);
        }

    }
}