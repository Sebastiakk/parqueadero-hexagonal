package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.Cupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.exepciones.ExceptionNoExiste;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;

/**
 * ServicioActualizarCupo
 */
public class ServicioActualizarCupo {

    private PuertoRepositorioCupo repo;

    public ServicioActualizarCupo(PuertoRepositorioCupo repoCupos) {
        this.repo = repoCupos;
    }

    public Cupos actualizar(String placa) {
        this.existe(placa);
        Cupos modelCupo = repo.buscarPlaca(placa);
        modelCupo.setHoraSalida(new Date());
        modelCupo.setValor(this.calcularPrecio(modelCupo));
        return repo.crear(modelCupo);
    }

    private void existe(String placa) {
        if (!this.repo.existe(placa)) {
            throw new ExceptionNoExiste(Constantes.MENSAJE_VEHICULO_NO_EXISTENTE);
        }
    }

    private int calcularPrecio(Cupos cupo) {
        float precio = 0;
        long tiempoParqueado = cupo.getHoraSalida().getTime() - cupo.getHoraEntrada().getTime();
        long minutos = TimeUnit.MILLISECONDS.toMinutes(tiempoParqueado);
        tiempoParqueado = TimeUnit.MILLISECONDS.toHours(tiempoParqueado);
        long dias = (tiempoParqueado / 24);
        long horasSobrantes = (tiempoParqueado - (dias * 24));
        if (minutos % 60 > 0) {
            horasSobrantes++;
        }
        if (horasSobrantes >= 9) {
            dias++;
            horasSobrantes = 0;
        }
        if (horasSobrantes == 0 && dias == 0) {
            horasSobrantes = 1;
        }
        if (cupo.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_MOTO)) {
            precio += dias * Constantes.PRECIO_DIA_MOTO;
            precio += horasSobrantes * Constantes.PRECIO_HORA_HORA;
            if (cupo.getCilindraje() > 500) {
                precio += Constantes.PRECIO_CILINDRAJE;
            }
        }
        if (cupo.getTipoVehiculo().equalsIgnoreCase(Constantes.TIPO_VEHICULO_CARRO)) {
            precio += dias * Constantes.PRECIO_DIA_CARRO;
            precio += horasSobrantes * Constantes.PRECIO_HORA_CARRO;
        }
        return (int) precio;
    }

}