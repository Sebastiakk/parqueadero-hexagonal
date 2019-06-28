package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.*;

/**
 * ValidadorArgumentos
 */
public class ValidarArgumentos {

    private ValidarArgumentos() {
    }

    public static void ExeptionPlaca(Object value, String mensaje) {
        if (value == null) {
            throw new ExeptionPlaca(mensaje);
        }
    }

    public static void ExeptionRequired(Object data, String mensaje) {
        if (data == null || data.equals(Constantes.TEXT_VACIO)) {
            throw new ExeptionRequired(mensaje);
        }
    }

    public static void ExeptionDiferenteCero(int data, String mensaje) {
        if (data == Constantes.CERO) {
            throw new ExeptionDiferenteCero(mensaje);
        }
    }

    public static void ExeptionTipoVehiculo(String data, String mensaje) {
        if (!data.equals(Constantes.TIPO_VEHICULO_CARRO) && !data.equals(Constantes.TIPO_VEHICULO_CARRO)) {
            throw new ExeptionTipoVehiculo(mensaje);
        }
    }

}