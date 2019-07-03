package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper.MapperCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.repositorio.RepoCupos;

/**
 * ImplementacionCupos
 */
@Repository
public class ImplementacionCupos implements PuertoRepositorioCupo {

    private RepoCupos query;
    private MapperCupos mapper;

    public ImplementacionCupos() {

    }

    public ImplementacionCupos(RepoCupos query, MapperCupos mapper) {
        this.query = query;
        this.mapper = mapper;
    }

    @Override
    public List<ModelCupos> list() {
        return null;
    }

    @Override
    public int countTipoVehiculo(String tipo) {
        return 0;
    }

    @Override
    public boolean existe(String placa) {
        return false;
    }

    @Override
    public ModelCupos create(ModelCupos cupo) {
        return null;
    }

    @Override
    public ModelCupos buscarPlaca(String placa) {
        return null;
    }

}