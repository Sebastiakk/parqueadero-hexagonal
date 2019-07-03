package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.mapper;

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
        ModelCupos data = new ModelCupos(entity.getIdCupo(), entity.getPlaca(), entity.getHoraEntrada(),entity.getHoraSalida(),
                entity.getTipoVehiculo(), entity.getCilindraje(),entity.getValor());
        return data;
    }
}