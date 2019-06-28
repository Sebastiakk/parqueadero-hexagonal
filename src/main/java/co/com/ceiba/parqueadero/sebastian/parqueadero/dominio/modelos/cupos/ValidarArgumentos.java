package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos;

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
        if (data == null || data.equals("")) {
            throw new ExeptionRequired(mensaje);
        }
    }

    public static void ExeptionDiferenteCero(int data, String mensaje) {
        if (data == 0) {
            throw new ExeptionDiferenteCero(mensaje);
        }
    }

    public static void ExeptionTipoVehiculo(String data, String mensaje) {
        if (!data.equals("Moto") && !data.equals("Carro")) {
            throw new ExeptionTipoVehiculo(mensaje);
        }
    }

}