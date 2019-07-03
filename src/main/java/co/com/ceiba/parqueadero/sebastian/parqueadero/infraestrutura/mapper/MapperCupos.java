package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.EntityCupos;

/**
 * MapperCupos
 */
@Component
public class MapperCupos {

    public MapperCupos() {
    }

    public EntityCupos convertirEntity(ModelCupos model) {
        EntityCupos data = new EntityCupos(model.getIdCupo(), model.getPlaca(), model.getHoraEntrada(),
                model.getHoraSalida(), model.getTipoVehiculo(), model.getCilindraje(), model.getValor());
        return data;
    }

    public ModelCupos convertirModel(EntityCupos entity) {
        ModelCupos data = new ModelCupos(entity.getIdCupo(), entity.getPlaca(), entity.getHoraEntrada(),
                entity.getHoraSalida(), entity.getTipoVehiculo(), entity.getCilindraje(), entity.getValor());
        return data;
    }

    public List<ModelCupos> listConvertToDomain(Iterable<EntityCupos> list) {
        final List<ModelCupos> listModel = new ArrayList<>();

        list.forEach(entity -> listModel.add(new ModelCupos(entity.getIdCupo(), entity.getPlaca(), entity.getHoraEntrada(),
        entity.getHoraSalida(), entity.getTipoVehiculo(), entity.getCilindraje(), entity.getValor())));

        return listModel;
    }
}