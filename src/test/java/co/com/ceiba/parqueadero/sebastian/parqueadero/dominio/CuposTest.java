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
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionRequired.class, Constantes.REQUIRED_PLACA);
    }

    @Test
    public void validarVehiculo() {
        this.cupoBuild.tipoVehiculo(null);
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionRequired.class, Constantes.REQUIRED_TIPO_VEHICULO);
    }

    @Test
    public void validarCilindraje() {
        this.cupoBuild.tipoVehiculo("Moto");
        this.cupoBuild.cilindraje(0);
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionDiferenteCero.class, Constantes.REQUIRED_CILINDRAJE);
    }

    @Test
    public void validarTiposVehiculo() {
        this.cupoBuild.tipoVehiculo("moto");
        TestBase.assertThrows(() -> this.cupoBuild.build(), ExeptionTipoVehiculo.class, Constantes.TIPOS_VEHICULO);
    }
}