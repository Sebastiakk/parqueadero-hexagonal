package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

// import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.Before;

import co.com.ceiba.parqueadero.sebastian.parqueadero.TestBase;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionRequired;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionTipoVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionDiferenteCero;

/**
 * CuposTest
 */
public class CuposTest {
    CuposBuild cupoBuild;

    @Before
    public void antes() {
        this.cupoBuild = new CuposBuild();
    }

    @Test
    public void validarPlaca() {
        this.cupoBuild.placa(null);
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionRequired.class, Constantes.MENSAJE_REQUIRED_PLACA);
    }

    @Test
    public void validarVehiculo() {
        this.cupoBuild.tipoVehiculo(null);
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionRequired.class, Constantes.MENSAJE_REQUIRED_TIPO_VEHICULO);
    }

    @Test
    public void validarCilindraje() {
        this.cupoBuild.tipoVehiculo(Constantes.TIPO_VEHICULO_MOTO);
        this.cupoBuild.cilindraje(Constantes.CERO);
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionDiferenteCero.class,
                Constantes.MENSAJE_REQUIRED_CILINDRAJE);
    }

    @Test
    public void validarTiposVehiculo() {
        this.cupoBuild.tipoVehiculo("moto");
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionTipoVehiculo.class, Constantes.MENSAJE_TIPOS_VEHICULO);
    }
}