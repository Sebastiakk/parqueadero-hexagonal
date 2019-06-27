package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionRequired extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionRequired(String message) {
        super(message);
    }
}
