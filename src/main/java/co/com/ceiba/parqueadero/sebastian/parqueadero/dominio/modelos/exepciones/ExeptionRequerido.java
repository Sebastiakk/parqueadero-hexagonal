package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionRequerido extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionRequerido(String message) {
        super(message);
    }
}
