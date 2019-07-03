package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.persistencia.EntityCupos;

/**
 * RepoCupos
 * 
 * Este es el repositorio en donde se encuentran todas las consultas
 */
public interface RepoCupos extends CrudRepository<EntityCupos, Long> {

    @Query("SELECT COUNT(idCupo) FROM EntityCupos WHERE tipoVehiculo = :tipoVehiculo AND horaSalida IS NULL")
    int contarTipoVehiculo(@Param("tipoVehiculo") String tipoVehiculo);

    @Query("SELECT e FROM EntityCupos e WHERE e.tipoVehiculo = :tipoVehiculo AND e.horaSalida IS NULL")
    EntityCupos buscarPorPlaca(@Param("tipoVehiculo") String tipoVehiculo);

    @Query("SELECT CASE WHEN COUNT(r.idCupo) > 0 THEN true ELSE false END FROM EntityCupos r WHERE r.tipoVehiculo = :tipoVehiculo AND r.horaSalida IS NULL")
    boolean existe(@Param("tipoVehiculo") String tipoVehiculo);

}