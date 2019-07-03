package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler.ActualizarHandler;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler.RegistrarHandler;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.consultas.ListadoCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.repositorio.PuertoRepositorioCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioActualizarCupo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioGuardarVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.servicios.ServicioListarCupos;

/**
 * ConfiguracionBean
 */

@Configuration
public class ConfiguracionBean {

    @Bean
    public RegistrarHandler crearHandler(ServicioGuardarVehiculo data) {
        return new RegistrarHandler(data);
    }

    @Bean
    public ServicioGuardarVehiculo creaServicio(PuertoRepositorioCupo puerto) {
        return new ServicioGuardarVehiculo(puerto);
    }

    @Bean
    public ActualizarHandler actualizarHandler(ServicioActualizarCupo data) {
        return new ActualizarHandler(data);
    }

    @Bean
    public ServicioActualizarCupo actualizarServicio(PuertoRepositorioCupo puerto) {
        return new ServicioActualizarCupo(puerto);
    }

    @Bean
    public ListadoCupos listarHandler(ServicioListarCupos data) {
        return new ListadoCupos(data);
    }

    @Bean
    public ServicioListarCupos listarServicio(PuertoRepositorioCupo puerto) {
        return new ServicioListarCupos(puerto);
    }

}