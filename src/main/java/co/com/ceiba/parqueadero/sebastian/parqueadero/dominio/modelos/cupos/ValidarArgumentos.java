package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.*;

/**
 * ValidadorArgumentos
 */
public final class ValidarArgumentos {

    private ValidarArgumentos() {
        throw new IllegalStateException("No se puede instanciar");
    }

    public static void exeptionPlaca(Object value, String mensaje) {
        if (value == null || value.equals(Constantes.TEXT_VACIO)) {
            throw new ExeptionPlaca(mensaje);
        }
    }

    public static void exeptionRequired(Object data, String mensaje) {
        if (data == null || data.equals(Constantes.TEXT_VACIO)) {
            throw new ExeptionRequired(mensaje);
        }
    }

    public static void exeptionDiferenteCero(int data, String mensaje) {
        if (data == Constantes.CERO) {
            throw new ExeptionDiferenteCero(mensaje);
        }
    }

    public static void exeptionTipoVehiculo(String data, String mensaje) {
        if (!data.equals(Constantes.TIPO_VEHICULO_CARRO) && !data.equals(Constantes.TIPO_VEHICULO_MOTO)) {
            throw new ExeptionTipoVehiculo(mensaje);
        }
    }

}