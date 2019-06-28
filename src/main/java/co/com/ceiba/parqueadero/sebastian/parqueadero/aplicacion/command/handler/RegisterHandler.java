package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioCupos;

public class RegisterHandler {

    private final ServicioCupos servicioCupos;

    public RegisterHandler(ServicioCupos servicioCupos) {
        this.servicioCupos = servicioCupos;
    }

    public void create(RegisterCommand register) {
        ModelCupos cupo = new ModelCupos(register.getIdCupo(), register.getPlaca(), register.getHoraEntrada(),
                register.getHoraSalida(), register.getTipoVehiculo(), register.getCilindraje());

        this.servicioCupos.create(cupo);
    }

}
