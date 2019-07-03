package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;

/**
 * RepoCupos
 */
public interface PuertoRepositorioCupo {

    ModelCupos create(ModelCupos cupo);

    List<ModelCupos> list();

    int countTipoVehiculo(String tipo);

    ModelCupos buscarPlaca(String placa);

    boolean existe(String placa);
}