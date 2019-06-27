package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExceptionExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionExiste(String message) {
        super(message);
    }
}
