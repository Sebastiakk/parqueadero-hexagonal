package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;

/**
 * ServicioListarCupos
 */
public class ServicioListarCupos {
    private PuertoRepositorioCupo puerto;

    public ServicioListarCupos(PuertoRepositorioCupo repoCupos) {
        this.puerto = repoCupos;
    }

    public List<ModelCupos> listar() {
        return this.puerto.list();

    }

}