package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.EntityVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.InterfaceVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.HttpRespuestas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ControlVehiculo
 */
@RestController
@RequestMapping(path = "/vehiculo", produces = "application/json")
public class Vehiculo {
    @Autowired()
    private InterfaceVehiculo vehiculo;

    @GetMapping()
    public Object get_all_vehiculo() {
        try {
            return HttpRespuestas._200(vehiculo.findAll(), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @GetMapping("/{id}")
    public Object get_vehiculo(@PathVariable long id) {
        try {
            return HttpRespuestas._200(vehiculo.findById(id), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @PostMapping("/")
    public Object crear_vehiculo(@RequestBody EntityVehiculo body) {
        try {
            return HttpRespuestas._200(vehiculo.save(body), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }
}