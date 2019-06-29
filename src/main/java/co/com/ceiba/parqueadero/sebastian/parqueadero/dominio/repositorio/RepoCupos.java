package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;

/**
 * RepoCupos
 */
public interface RepoCupos {

    void create(ModelCupos cupo);

    void update(ModelCupos cupo);

    List<ModelCupos> list();

    int countTipoVehiculo(String tipo);

    boolean existe(String placa);
}