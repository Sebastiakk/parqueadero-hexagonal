package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 * ImplementParqueadero
 */
@Service
public class ImplementParqueadero implements InterfaceParqueadero {

    @Autowired
    private CrudRepository<EntityParqueadero, Long> parqueadero;

    @Override
    @Transactional(readOnly = true)
    public List<EntityParqueadero> findAll() {
        return (List<EntityParqueadero>) parqueadero.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public EntityParqueadero findById(long id) {
        return parqueadero.findById(id).orElse(null);
    }

    @Override
    public EntityParqueadero save(EntityParqueadero data) {
        return parqueadero.save(data);
    }

}