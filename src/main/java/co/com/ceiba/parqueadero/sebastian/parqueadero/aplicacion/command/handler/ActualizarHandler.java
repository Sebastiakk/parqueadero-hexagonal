package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioActualizarCupo;

public class ActualizarHandler {

    private final ServicioActualizarCupo servicioCupos;

    public ActualizarHandler(ServicioActualizarCupo servicioCupos) {
        this.servicioCupos = servicioCupos;
    }

    public ModelCupos actualizar(String placa) {
        return this.servicioCupos.actualizar(placa);
    }

}
