package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicio;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.CuposBuild;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionNoAutorizado;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionNoExiste;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionCapacidadMaxima;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioActualizarCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.util.Calendar;

/**
 * ServicioTest
 */
public class ServicioTest {

    private PuertoRepositorioCupo puertoRepositorioCupo;
    private ServicioGuardarVehiculo servicioGuardar;
    private ServicioActualizarCupo servicioActualizar;
    private CuposBuild build;

    @Before
    public void inicio() {
        puertoRepositorioCupo = mock(PuertoRepositorioCupo.class);
        this.build = new CuposBuild();
        this.servicioGuardar = new ServicioGuardarVehiculo(puertoRepositorioCupo);
        this.servicioActualizar = new ServicioActualizarCupo(puertoRepositorioCupo);
    }

    @Test
    public void preparacionCrear() {
        // act
        this.servicioGuardar = new ServicioGuardarVehiculo(puertoRepositorioCupo);
        // assert
        assertNotNull(this.puertoRepositorioCupo);
        assertNotNull(this.servicioGuardar);
    }

    @Test
    public void crearCarro() {
        // Arrange
        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.crear(modelCupos)).thenReturn(modelCupos);
        // Act
        Cupos copia = servicioGuardar.crear(modelCupos);
        // Assert
        assertEquals(copia.getIdCupo(), modelCupos.getIdCupo());
    }

    @Test
    public void crearMoto() {
        // Arrange
        this.build.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
        this.build.cilindraje(Constantes.CILINDRAJE);
        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.crear(modelCupos)).thenReturn(modelCupos);
        // Act
        Cupos copia = servicioGuardar.crear(modelCupos);
        // Assert
        assertEquals(copia.getIdCupo(), modelCupos.getIdCupo());
    }

    @Test
    public void cantidadMaximaCarro() {
        // Arrange
        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.countTipoVehiculo(Constantes.TIPO_VEHICULO_CARRO)).thenReturn(Constantes.MAX_CARRO);
        // Act
        try {
            servicioGuardar.crear(modelCupos);
            fail();
        } catch (ExeptionCapacidadMaxima err) {
            // Assert
            assertEquals(Constantes.MENSAJE_CAPACIDAD_MAXIMA, err.getMessage());
        }
    }

    @Test
    public void cantidadMaximaMoto() {
        // Arrange
        this.build.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
        this.build.cilindraje(Constantes.CILINDRAJE);
        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.countTipoVehiculo(Constantes.TIPO_VEHICULO_MOTO)).thenReturn(Constantes.MAX_MOTO);
        // Act
        try {
            servicioGuardar.crear(modelCupos);
            fail();
        } catch (ExeptionCapacidadMaxima err) {
            // Assert
            assertEquals(Constantes.MENSAJE_CAPACIDAD_MAXIMA, err.getMessage());
        }
    }

    @Test
    public void validarLetraPlaca() {
        // Arrange

        Calendar horaEntrada = Calendar.getInstance();
        horaEntrada.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
        this.build.placa(Constantes.PLACA_CON_A);
        this.build.horaEntrada(horaEntrada.getTime());

        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.crear(modelCupos)).thenReturn(modelCupos);
        // Act
        try {
            servicioGuardar.crear(modelCupos);
            fail();
        } catch (ExceptionNoAutorizado err) {
            // Assert
            assertEquals(Constantes.MENSAJE_NO_AUTORIZADO, err.getMessage());
        }
    }

    @Test
    public void preparacionActualizar() {
        // act
        this.servicioActualizar = new ServicioActualizarCupo(puertoRepositorioCupo);
        // assert
        assertNotNull(this.puertoRepositorioCupo);
        assertNotNull(this.servicioActualizar);
    }

    @Test
    public void actualizarCupoSiExisteElVehiculo() {
        // Arrange
        Cupos modelCupos = this.build.build();
        when(puertoRepositorioCupo.crear(modelCupos)).thenReturn(modelCupos);
        // Act
        try {
            servicioActualizar.actualizar(modelCupos.getPlaca());
            fail();
        } catch (ExceptionNoExiste e) {
            // Assert
            assertEquals(Constantes.MENSAJE_VEHICULO_NO_EXISTENTE, e.getMessage());
        }
    }

}