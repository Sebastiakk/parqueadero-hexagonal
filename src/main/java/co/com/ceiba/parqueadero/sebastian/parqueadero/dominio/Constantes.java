package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

/**
 * Constantes
 */
public final class Constantes {

    // No se puede instanciar porque lo unico que se necesita son las constantes
    private Constantes() {
        throw new IllegalStateException("No se puede instanciar");
    }

    public static final String REQUIRED_PLACA = "La placa es requerida";
    public static final String REQUIRED_TIPO_VEHICULO = "El tipo de vehiculo es requirido";
    public static final String REQUIRED_CILINDRAJE = "El cilindraje es requerido";
    public static final String TIPO_VEHICULO_MOTO = "Moto";
    public static final String TIPO_VEHICULO_CARRO = "Carro";
    public static final String TIPOS_VEHICULO = "El tipo de vehiculo es Moto o Carro";
    public static final String TEXT_VACIO = "";
    public static final int CERO = 0;
    public static final int MAX_CARRO = 20;
    public static final int MAX_MOTO = 10;
    public static final String PRIMERA_LETRA_PLACA = "A";
    public static final String CAPACIDAD_MAXIMA = "El parqueadero alcanzo la capacidad maxima para este tipo de vehiculo";
    public static final String EXISTENTE = "EL vehiculo se encuentra en el parqueadero";
    public static final String NO_AUTORIZADO = "Este vehiculo no esta autorizado para ingresar hoy";
}