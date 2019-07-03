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

    @Query("SELECT e FROM EntityCupos e WHERE e.placa = :placa AND e.horaSalida IS NULL")
    EntityCupos buscarPorPlaca(@Param("placa") String placa);

    @Query("SELECT CASE WHEN COUNT(r.idCupo) > 0 THEN true ELSE false END FROM EntityCupos r WHERE r.placa = :placa AND r.horaSalida IS NULL")
    boolean existe(@Param("placa") String placa);

}