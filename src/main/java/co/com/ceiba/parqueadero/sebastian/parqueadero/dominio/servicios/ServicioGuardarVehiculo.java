package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionExiste;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionNoAutorizado;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionCapacidadMaxima;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.RepoCupos;

/**
 * ServicioCupos
 */
public class ServicioGuardarVehiculo {

    private RepoCupos repoCupos;

    public ServicioGuardarVehiculo(RepoCupos repoCupos) {
        this.repoCupos = repoCupos;
    }

    public void create(ModelCupos data) {
        this.existe(data.getPlaca());
        this.catidadTipoVehiculo(data.getTipoVehiculo());
        this.validarPrimeraLetraPlaca(data.getPlaca(), data.getHoraEntrada());
        this.repoCupos.create(data);
    }

    private void existe(String placa) {
        if (this.repoCupos.existe(placa)) {
            throw new ExceptionExiste(Constantes.EXISTENTE);
        }
    }

    private void catidadTipoVehiculo(String tipoVehiculo) {
        int cantidad = this.repoCupos.countTipoVehiculo(tipoVehiculo);
        if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_MOTO) && cantidad >= Constantes.MAX_MOTO) {
            throw new ExeptionCapacidadMaxima(Constantes.CAPACIDAD_MAXIMA);
        } else if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_CARRO) && cantidad >= Constantes.MAX_CARRO) {
            throw new ExeptionCapacidadMaxima(Constantes.CAPACIDAD_MAXIMA);
        }
    }

    private void validarPrimeraLetraPlaca(String placa, Date date) {
        Calendar hoy = Calendar.getInstance();
        hoy.setTimeInMillis(date.getTime());
        int dia = hoy.get(Calendar.DAY_OF_WEEK);
        if (placa.startsWith(Constantes.PRIMERA_LETRA_PLACA) && (dia > Calendar.MONDAY)) {
            throw new ExceptionNoAutorizado(Constantes.NO_AUTORIZADO);
        }
    }

}