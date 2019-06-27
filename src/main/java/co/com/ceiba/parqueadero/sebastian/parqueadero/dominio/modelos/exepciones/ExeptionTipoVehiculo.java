package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionTipoVehiculo extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionTipoVehiculo(String message) {
        super(message);
    }
}