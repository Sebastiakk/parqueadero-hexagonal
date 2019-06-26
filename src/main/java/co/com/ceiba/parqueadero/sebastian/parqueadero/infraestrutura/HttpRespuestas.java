package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura;

import java.util.HashMap;

/**
 * HttpRespuestas
 */
public class HttpRespuestas {

    public static HashMap<String, Object> _200(Object data, String mensaje) {
        if (mensaje == null) {
            mensaje = "Ejecucion exitosa";
        }
        if (data != null) {
            return _otro(200, mensaje, data, true);
        } else {
            return _404(null);
        }
    }

    public static HashMap<String, Object> _404(String mensaje) {
        if (mensaje == null) {
            mensaje = "Datos no encontrados";
        }
        return _otro(404, mensaje, null, false);
    }

    public static HashMap<String, Object> _500(String mensaje) {
        if (mensaje == null) {
            mensaje = "Error en la ejecucion";
        }
        return _otro(500, mensaje, null, false);
    }

    public static HashMap<String, Object> _otro(int code, String mensaje, Object data, Boolean estado) {
        HashMap<String, Object> respuesta = new HashMap<String, Object>();
        respuesta.put("code", code);
        respuesta.put("estado", estado);
        respuesta.put("mensaje", mensaje);
        respuesta.put("data", data);
        return respuesta;
    }

}