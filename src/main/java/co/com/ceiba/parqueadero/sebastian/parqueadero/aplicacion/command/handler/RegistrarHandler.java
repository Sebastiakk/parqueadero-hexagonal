package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;

public class RegistrarHandler {

    private final ServicioGuardarVehiculo servicioCupos;

    public RegistrarHandler(ServicioGuardarVehiculo servicioCupos) {
        this.servicioCupos = servicioCupos;
    }

    public Cupos crear(RegisterCommand register) {
        Cupos cupo = new Cupos(register.getIdCupo(), register.getPlaca(), new Date(),
                register.getHoraSalida(), register.getTipoVehiculo(), register.getCilindraje(), register.getValor());

        return this.servicioCupos.crear(cupo);
    }

}
