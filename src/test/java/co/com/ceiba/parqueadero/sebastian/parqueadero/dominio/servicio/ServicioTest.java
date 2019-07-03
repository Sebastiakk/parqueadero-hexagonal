package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicio;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.CuposBuild;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * ServicioTest
 */
public class ServicioTest {

    private PuertoRepositorioCupo puertoRepositorioCupo;

    @Before
    public void StartMocks() {
        puertoRepositorioCupo = mock(PuertoRepositorioCupo.class);
    }

    @Test
    public void RegisterCarTest() {
        // Arrange
        CuposBuild build = new CuposBuild();

        ModelCupos modelCupos = build.build();

        ServicioGuardarVehiculo registerEntryService = new ServicioGuardarVehiculo(puertoRepositorioCupo);

        when(puertoRepositorioCupo.create(modelCupos)).thenReturn(modelCupos);

        // Act
        ModelCupos registerCopy = registerEntryService.create(modelCupos);

        // Assert
        assertEquals(registerCopy.getIdCupo(), modelCupos.getIdCupo());

    }
}