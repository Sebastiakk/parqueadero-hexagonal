package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicio;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.CuposBuild;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionCapacidadMaxima;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * ServicioTest
 */
public class ServicioTest {

    private PuertoRepositorioCupo puertoRepositorioCupo;
    private ServicioGuardarVehiculo registerEntryService;
    private CuposBuild build;

    @Before
    public void StartMocks() {
        puertoRepositorioCupo = mock(PuertoRepositorioCupo.class);
        this.build = new CuposBuild();
        this.registerEntryService = new ServicioGuardarVehiculo(puertoRepositorioCupo);

    }

    @Test
    public void crearCarro() {
        // Arrange
        ModelCupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.create(modelCupos)).thenReturn(modelCupos);
        // Act
        ModelCupos copia = registerEntryService.create(modelCupos);
        // Assert
        assertEquals(copia.getIdCupo(), modelCupos.getIdCupo());
    }

    @Test
    public void crearMoto() {
        // Arrange
        this.build.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
        this.build.cilindraje(Constantes.CILINDRAJE);
        ModelCupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.create(modelCupos)).thenReturn(modelCupos);
        // Act
        ModelCupos copia = registerEntryService.create(modelCupos);
        // Assert
        assertEquals(copia.getIdCupo(), modelCupos.getIdCupo());
    }

    @Test
    public void cantidadMaximaCarro() {
        // Arrange
        ModelCupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.countTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.MAX_CARRO);
        // Act
        try {
            registerEntryService.create(modelCupos);
            fail();
        } catch (ExeptionCapacidadMaxima err) {
            // Assert
            assertEquals(Constantes.CAPACIDAD_MAXIMA, err.getMessage());
        }
    }

    @Test
    public void cantidadMaximaMoto() {
        // Arrange
        this.build.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
        this.build.cilindraje(Constantes.CILINDRAJE);
        ModelCupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.countTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.MAX_MOTO);
        // Act
        try {
            registerEntryService.create(modelCupos);
            fail();
        } catch (ExeptionCapacidadMaxima err) {
            // Assert
            assertEquals(Constantes.CAPACIDAD_MAXIMA, err.getMessage());
        }
    }


}