package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.implementacion;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper.MapperCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.EntityCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.repositorio.RepoCupos;

/**
 * ImplementacionCupos
 * NOTE nombre completo con la BD que se este utilizando para el query
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
    public List<Cupos> list() {
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
    public Cupos crear(Cupos cupo) {
        EntityCupos data = mapper.convertirEntity(cupo);
        return mapper.convertirModel(query.save(data));
    }

    @Override
    public Cupos buscarPlaca(String placa) {
        return mapper.convertirModel(query.buscarPorPlaca(placa));
    }

}