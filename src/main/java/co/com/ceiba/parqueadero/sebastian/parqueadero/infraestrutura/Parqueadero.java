package co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.EntityParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.InterfaceParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.HttpRespuestas;

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
public class Parqueadero {
    @Autowired()
    private InterfaceParqueadero parqueadero;

    @GetMapping()
    public Object getAll() {
        try {
            return HttpRespuestas._200(parqueadero.findAll(), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable long id) {
        try {
            return HttpRespuestas._200(parqueadero.findById(id), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @PostMapping("/")
    public Object crear(@RequestBody EntityParqueadero body) {
        try {
            return HttpRespuestas._200(parqueadero.save(body), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

}