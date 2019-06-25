package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo;

import java.util.List;

/**
 * InterfaceVehiculo
 */

public interface InterfaceVehiculo {

    public List<EntityVehiculo> findAll();

    public EntityVehiculo findById(long id);

    public EntityVehiculo save(EntityVehiculo data);
}