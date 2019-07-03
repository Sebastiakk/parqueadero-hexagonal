package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ValidarArgumentos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionDiferenteCero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionPlaca;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionRequired;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionTipoVehiculo;

public class ValidadorArgumentosTest {

	@Test
	public void argumentoPlacaRequerida() {
		try {
			// act
			ValidarArgumentos.exeptionPlaca(null, Constantes.MENSAJE_REQUIRED_PLACA);
			fail();
		} catch (ExeptionPlaca e) {
			// assert
			assertEquals(e.getMessage(), Constantes.MENSAJE_REQUIRED_PLACA);
		}
	}

	@Test
	public void argumentoDatosRequeridos() {
		try {
			ValidarArgumentos.exeptionRequired(null, Constantes.MENSAJE_REQUIRED);
			fail();
		} catch (ExeptionRequired e) {
			assertEquals(e.getMessage(), Constantes.MENSAJE_REQUIRED);
		}
	}

	@Test
	public void argumentoDiferenteDeCero() {
		try {
			ValidarArgumentos.exeptionDiferenteCero(Constantes.CERO, Constantes.MENSAJE_REQUIRED);
			fail();
		} catch (ExeptionDiferenteCero e) {
			assertEquals(e.getMessage(), Constantes.MENSAJE_REQUIRED);
		}
	}

	@Test
	public void argumentoTipoVehiculo() {
		try {
			ValidarArgumentos.exeptionTipoVehiculo(Constantes.TIPO_VEHICULO_OTRO, Constantes.MENSAJE_TIPOS_VEHICULO);
			fail();
		} catch (ExeptionTipoVehiculo e) {
			assertEquals(e.getMessage(), Constantes.MENSAJE_TIPOS_VEHICULO);
		}
	}

}
