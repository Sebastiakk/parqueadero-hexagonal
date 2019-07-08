package co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.consultas;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioListarCupos;

/**
 * ListadoCupos
 */
public class ListadoCupos {

    ServicioListarCupos cupos;

    public ListadoCupos(ServicioListarCupos cupos) {
        this.cupos = cupos;
    }

    public List<Cupos> listarCupos() {
        return cupos.listar();
    }

}