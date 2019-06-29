package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionCapacidadMaxima extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionCapacidadMaxima(String message) {
        super(message);
    }
}