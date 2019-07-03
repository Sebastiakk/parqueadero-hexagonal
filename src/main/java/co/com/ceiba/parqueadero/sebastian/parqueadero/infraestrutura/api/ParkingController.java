package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.api;

// import co.com.ceiba.parqueadero.sebastian.application.command.RegisterCommand;
// import co.com.ceiba.parqueadero.sebastian.application.command.handler.RegisterEntryHandler;
// import co.com.ceiba.parqueadero.sebastian.application.command.handler.RegisterExitHandler;
// import co.com.ceiba.parqueadero.sebastian.application.consulta.RegisterListHandler;
// import co.com.ceiba.parqueadero.sebastian.domain.model.Registry;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.handler.RegistrarHandler;
import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.consultas.ListadoCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.modelos.cupos.ModelCupos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import java.util.List;

@RestController
@RequestMapping(path = "/parqueadero", produces = "application/json")
@CrossOrigin("*")
public class ParkingController {

    private RegistrarHandler registerHandler;
    // private RegisterExitHandler registerExitHandler;
    private ListadoCupos listarHandler;

    @Autowired
    public ParkingController(RegistrarHandler registerHandler, ListadoCupos listarHandler) {
        this.registerHandler = registerHandler;
        this.listarHandler = listarHandler;
    }

    // @Autowired
    // public ParkingController(RegisterEntryHandler registerHandler,
    // RegisterExitHandler registerExitHandler, RegisterListHandler
    // registerListHandler){
    // this.registerHandler = registerHandler;
    // this.registerExitHandler = registerExitHandler;
    // this.registerListHandler = registerListHandler;
    // }

    @GetMapping()
    public List<ModelCupos> List() {
        return this.listarHandler.listarCupos();
    }

    @PostMapping
    public ModelCupos guardarVehiculo(@RequestBody RegisterCommand body) {
        return this.registerHandler.create(body);
    }

    // @PutMapping("/{licensePlate}")
    // public void getOut(@PathVariable("licensePlate") String licensePlate) {
    // this.registerExitHandler.SetExit(licensePlate);
    // }
}
