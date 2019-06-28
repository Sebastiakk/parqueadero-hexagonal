package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;

/**
 * Cupos
 */
public class ModelCupos {

    private long idCupo;
    private String placa;
    private Date horaEntrada;
    private Date horaSalida;
    private String tipoVehiculo;
    private int cilindraje;

    public ModelCupos() {
    }

    public ModelCupos(long idCupo, String placa, Date horaEntrada, Date horaSalida, String tipoVehiculo,
            int cilindraje) {

        this.validarArgumentos(idCupo, placa, horaEntrada, horaSalida, tipoVehiculo, cilindraje);
        this.idCupo = idCupo;
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.tipoVehiculo = tipoVehiculo;
    }

    private void validarArgumentos(long idCupo, String placa, Date horaEntrada, Date horaSalida, String tipoVehiculo,
            int cilindraje) {
        // Valida que la plata este en la data
        ValidarArgumentos.exeptionRequired(placa, Constantes.REQUIRED_PLACA);
        // Valida que el tipo de vehiculo este en la data
        ValidarArgumentos.exeptionRequired(tipoVehiculo, Constantes.REQUIRED_TIPO_VEHICULO);
        // Valida que el tipo de vehiculo sea correcto "Moto" o "Carro"
        ValidarArgumentos.exeptionTipoVehiculo(tipoVehiculo, Constantes.TIPOS_VEHICULO);

        // Si el tipo de vehiculo es moto valida que el cilindraje sea diferente de cero
        if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_MOTO)) {
            ValidarArgumentos.exeptionDiferenteCero(cilindraje, Constantes.REQUIRED_CILINDRAJE);
        }

    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public long getIdCupo() {
        return this.idCupo;
    }

    public void setIdCupo(long idCupo) {
        this.idCupo = idCupo;
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getHoraEntrada() {
        return this.horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getTipoVehiculo() {
        return this.tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

}