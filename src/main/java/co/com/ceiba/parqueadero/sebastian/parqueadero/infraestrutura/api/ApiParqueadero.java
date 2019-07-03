package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.api;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler.ActualizarHandler;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler.RegistrarHandler;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.consultas.ListadoCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/parqueadero", produces = "application/json")
@CrossOrigin("*")
public class ApiParqueadero {

    private RegistrarHandler registerHandler;
    private ListadoCupos listarHandler;
    private ActualizarHandler actualizarHandler;

    @Autowired
    public ApiParqueadero(RegistrarHandler registerHandler, ListadoCupos listarHandler,
            ActualizarHandler actualizarHandler) {
        this.registerHandler = registerHandler;
        this.listarHandler = listarHandler;
        this.actualizarHandler = actualizarHandler;
    }

    @GetMapping()
    public List<ModelCupos> List() {
        return this.listarHandler.listarCupos();
    }

    @PostMapping
    public ModelCupos guardarVehiculo(@RequestBody RegisterCommand body) {
        return this.registerHandler.create(body);
    }

    @PutMapping("/{placa}")
    public ModelCupos salidaVehiculo(@PathVariable("placa") String placa) {
        return this.actualizarHandler.actualizar(placa);
    }
}
