package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionPlaca extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionPlaca(String message) {
        super(message);
    }
}
