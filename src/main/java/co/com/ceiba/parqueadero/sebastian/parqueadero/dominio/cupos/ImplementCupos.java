package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.cupos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * ImplementCupos
 */
@Service
public class ImplementCupos  implements InterfaceCupos {

    @Autowired
    private CrudRepository<EntityCupos, Long> vehiculo;

    @Override
    @Transactional(readOnly = true)
    public List<EntityCupos> findAll() {
        return (List<EntityCupos>) vehiculo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EntityCupos findById(long id) {
        return vehiculo.findById(id).orElse(null);
    }

    @Override
    public EntityCupos save(EntityCupos data) {
        return vehiculo.save(data);
    }

}