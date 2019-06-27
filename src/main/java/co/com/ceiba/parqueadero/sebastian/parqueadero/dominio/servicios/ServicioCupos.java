package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionExiste;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.RepoCupos;

/**
 * ServicioCupos
 */
public class ServicioCupos {

    private RepoCupos repoCupos;

    public ServicioCupos(RepoCupos repoCupos) {
        this.repoCupos = repoCupos;
    }

    /**
     * Inserta el vehiculo
     */
    public void create(ModelCupos data) {
        this.existe(data);
        this.repoCupos.create(data);
    }

    /**
     * Valida si el vechiculo ya esta guardado
     */
    private void existe(ModelCupos data) {
        if (this.repoCupos.existe(data)) {
            throw new ExceptionExiste("El vehiculo ya esta ingresado");
        }
    }

    /**
     * 
     * @return listado de todos los cupos utilizados en el momento
     */
    public List<ModelCupos> listar() {
        return this.repoCupos.list();
    }
}