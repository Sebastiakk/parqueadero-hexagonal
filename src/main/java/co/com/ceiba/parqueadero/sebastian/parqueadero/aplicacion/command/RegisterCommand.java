package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command;

import java.util.Date;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommand {
        private long idCupo;
        private String placa;
        private Date horaEntrada;
        private Date horaSalida;
        private String tipoVehiculo;
        private int cilindraje;
}
