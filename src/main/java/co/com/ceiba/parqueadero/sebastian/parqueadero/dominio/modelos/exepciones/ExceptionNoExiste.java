package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExceptionNoExiste extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionNoExiste(String message) {
        super(message);
    }
}
