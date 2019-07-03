package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;

public class RegistrarHandler {

    private final ServicioGuardarVehiculo servicioCupos;

    public RegistrarHandler(ServicioGuardarVehiculo servicioCupos) {
        this.servicioCupos = servicioCupos;
    }

    public ModelCupos create(RegisterCommand register) {
        ModelCupos cupo = new ModelCupos(register.getIdCupo(), register.getPlaca(), new Date(),
                register.getHoraSalida(), register.getTipoVehiculo(), register.getCilindraje(), register.getValor());

        return this.servicioCupos.create(cupo);
    }

}
