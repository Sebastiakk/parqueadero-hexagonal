package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones;

public class ExeptionDiferenteCero extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ExeptionDiferenteCero(String message) {
        super(message);
    }
}