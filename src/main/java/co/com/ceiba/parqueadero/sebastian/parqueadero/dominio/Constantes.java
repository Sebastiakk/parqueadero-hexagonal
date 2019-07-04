package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

/**
 * Constantes
 */
public final class Constantes {
    /**
     * No se puede instanciar porque lo unico que se necesita son las constantes
     */
    private Constantes() {
        throw new IllegalStateException("No se puede instanciar");
    }

    public static final String PATH = "/parqueadero";
    public static final String TIPO_VEHICULO_MOTO = "Moto";
    public static final String TIPO_VEHICULO_CARRO = "Carro";
    public static final String TIPO_VEHICULO_OTRO = "Bicicleta";
    public static final String TEXT_VACIO = "";
    public static final String PRIMERA_LETRA_PLACA = "A";
    public static final String PLACA_CON_A = "ASEB-123";
    public static final String PLACA = "SEB-123";

    public static final String MENSAJE_REQUIRED_PLACA = "La placa es requerida";
    public static final String MENSAJE_REQUIRED_TIPO_VEHICULO = "El tipo de vehiculo es requirido";
    public static final String MENSAJE_REQUIRED_CILINDRAJE = "El cilindraje es requerido";
    public static final String MENSAJE_REQUIRED = "El dato es requerido";
    public static final String MENSAJE_TIPOS_VEHICULO = "El tipo de vehiculo es Moto o Carro";
    public static final String MENSAJE_CAPACIDAD_MAXIMA = "El parqueadero alcanzo la capacidad maxima para este tipo de vehiculo";
    public static final String MENSAJE_EXISTENTE = "EL vehiculo se encuentra en el parqueadero";
    public static final String MENSAJE_VEHICULO_NO_EXISTENTE = "El vehiculo no existe";
    public static final String MENSAJE_NO_AUTORIZADO = "Este vehiculo no esta autorizado para ingresar hoy";

    public static final int CERO = 0;
    public static final int MAX_CARRO = 20;
    public static final int MAX_MOTO = 10;
    public static final int CILINDRAJE = 160;

    public static final float PRECIO_HORA_CARRO = 1000;
    public static final float PRECIO_DIA_CARRO = 8000;
    public static final float PRECIO_HORA_HORA = 500;
    public static final float PRECIO_DIA_MOTO = 4000;
    public static final float PRECIO_CILINDRAJE = 2000;
}