package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios;

import java.util.Date;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;
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

    public ModelCupos actualizar(String placa) {
        this.existe(placa);
        ModelCupos modelCupo = repo.buscarPlaca(placa);
        modelCupo.setHoraSalida(new Date());
        // NOTE tengo que cambiar el 999 por la funcion que es
        modelCupo.setValor(999);
        return repo.create(modelCupo);
    }

    private void existe(String placa) {
        if (!this.repo.existe(placa)) {
            throw new ExceptionNoExiste(Constantes.NO_EXISTENTE);
        }
    }

}