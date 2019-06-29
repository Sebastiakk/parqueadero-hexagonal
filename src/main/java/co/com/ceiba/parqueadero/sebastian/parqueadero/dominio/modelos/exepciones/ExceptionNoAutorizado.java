package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExceptionNoAutorizado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExceptionNoAutorizado(String message) {
        super(message);
    }
}
