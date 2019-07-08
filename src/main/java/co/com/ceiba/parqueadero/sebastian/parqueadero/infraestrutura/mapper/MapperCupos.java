package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.EntityCupos;

/**
 * MapperCupos
 */
@Component
public class MapperCupos {

    public EntityCupos convertirEntity(Cupos model) {
        return new EntityCupos(model.getIdCupo(), model.getPlaca(), model.getHoraEntrada(), model.getHoraSalida(),
                model.getTipoVehiculo(), model.getCilindraje(), model.getValor());
    }

    public Cupos convertirModel(EntityCupos entity) {
        return new Cupos(entity.getIdCupo(), entity.getPlaca(), entity.getHoraEntrada(), entity.getHoraSalida(),
                entity.getTipoVehiculo(), entity.getCilindraje(), entity.getValor());
    }

    public List<Cupos> listConvertToDomain(Iterable<EntityCupos> list) {
        final List<Cupos> listModel = new ArrayList<>();

        list.forEach(
                entity -> listModel.add(new Cupos(entity.getIdCupo(), entity.getPlaca(), entity.getHoraEntrada(),
                        entity.getHoraSalida(), entity.getTipoVehiculo(), entity.getCilindraje(), entity.getValor())));

        return listModel;
    }
}