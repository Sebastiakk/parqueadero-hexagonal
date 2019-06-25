package co.com.ceiba.parqueadero.sebastian.parqueadero.controles;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.EntityParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.InterfaceParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.interfaces.HttpRespuestas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ControlParqueadero
 */
@RestController
@RequestMapping(path = "/parqueadero", produces = "application/json")
public class ControlParqueadero {
    @Autowired()
    private InterfaceParqueadero parqueadero;

    @GetMapping()
    public Object get_all_parqueadero() {
        try {
            return HttpRespuestas._200(parqueadero.findAll(), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @GetMapping("/{id}")
    public Object get_parqueadero(@PathVariable long id) {
        try {
            return HttpRespuestas._200(parqueadero.findById(id), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @PostMapping("/")
    public Object crear_parqueadero(@RequestBody EntityParqueadero body) {
        try {
            return HttpRespuestas._200(parqueadero.save(body), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

}