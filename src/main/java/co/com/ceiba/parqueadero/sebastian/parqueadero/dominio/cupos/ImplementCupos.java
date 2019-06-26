package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.cupos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ImplementCupos
 */
@Service
public class ImplementCupos  implements InterfaceCupos {

    @Autowired
    private DaoCupos cupos;

    @Override
    @Transactional(readOnly = true)
    public List<EntityCupos> findAll() {
        return (List<EntityCupos>) cupos.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EntityCupos findById(long id) {
        return cupos.findById(id).orElse(null);
    }

    @Override
    public EntityCupos save(EntityCupos data) {
        return cupos.save(data);
    }

}