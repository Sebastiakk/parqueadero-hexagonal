package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;

/**
 * RepoCupos
 */
public interface PuertoRepositorioCupo {

    Cupos crear(Cupos cupo);

    List<Cupos> list();

    int countTipoVehiculo(String tipo);

    Cupos buscarPlaca(String placa);

    boolean existe(String placa);
}