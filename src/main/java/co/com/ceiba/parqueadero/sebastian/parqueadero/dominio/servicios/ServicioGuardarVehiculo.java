package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionExiste;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionNoAutorizado;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExeptionCapacidadMaxima;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;

/**
 * ServicioCupos
 */
public class ServicioGuardarVehiculo {

    private PuertoRepositorioCupo repo;

    public ServicioGuardarVehiculo(PuertoRepositorioCupo repoCupos) {
        this.repo = repoCupos;
    }

    public Cupos crear(Cupos data) {
        this.existe(data.getPlaca());
        this.catidadTipoVehiculo(data.getTipoVehiculo());
        this.validarPrimeraLetraPlaca(data.getPlaca(), data.getHoraEntrada());
        return this.repo.crear(data);
    }

    private void existe(String placa) {
        if (this.repo.existe(placa)) {
            throw new ExceptionExiste(Constantes.MENSAJE_EXISTENTE);
        }
    }

    private void catidadTipoVehiculo(String tipoVehiculo) {
        int cantidad = this.repo.countTipoVehiculo(tipoVehiculo);
        if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_MOTO) && cantidad >= Constantes.MAX_MOTO) {
            throw new ExeptionCapacidadMaxima(Constantes.MENSAJE_CAPACIDAD_MAXIMA);
        } else if (tipoVehiculo.equals(Constantes.TIPO_VEHICULO_CARRO) && cantidad >= Constantes.MAX_CARRO) {
            throw new ExeptionCapacidadMaxima(Constantes.MENSAJE_CAPACIDAD_MAXIMA);
        }
    }

    private void validarPrimeraLetraPlaca(String placa, Date date) {
        Calendar hoy = Calendar.getInstance();
        hoy.setTimeInMillis(date.getTime());
        int dia = hoy.get(Calendar.DAY_OF_WEEK);
        if (placa.startsWith(Constantes.PRIMERA_LETRA_PLACA) && (dia > Calendar.MONDAY)) {
            throw new ExceptionNoAutorizado(Constantes.MENSAJE_NO_AUTORIZADO);
        }
    }

}