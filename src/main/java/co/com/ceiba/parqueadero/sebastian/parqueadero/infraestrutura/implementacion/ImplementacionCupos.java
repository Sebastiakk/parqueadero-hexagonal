package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper.MapperCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.EntityCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.repositorio.RepoCupos;

/**
 * ImplementacionCupos
 */
@Repository
public class ImplementacionCupos implements PuertoRepositorioCupo {

    private RepoCupos query;
    private MapperCupos mapper;

    public ImplementacionCupos(RepoCupos query, MapperCupos mapper) {
        this.query = query;
        this.mapper = mapper;
    }

    @Override
    public List<ModelCupos> list() {
        return mapper.listConvertToDomain(query.findAll());
    }

    @Override
    public int countTipoVehiculo(String tipo) {
        return query.contarTipoVehiculo(tipo);
    }

    @Override
    public boolean existe(String placa) {
        return query.existe(placa);
    }

    @Override
    public ModelCupos create(ModelCupos cupo) {
        EntityCupos data = mapper.convertirEntity(cupo);
        return mapper.convertirModel(query.save(data));
    }

    @Override
    public ModelCupos buscarPlaca(String placa) {
        return mapper.convertirModel(query.buscarPorPlaca(placa));
    }

}