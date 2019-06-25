package co.com.ceiba.parqueadero.sebastian.parqueadero.controles;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.cupos.EntityCupos;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.cupos.InterfaceCupos;
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
@RequestMapping(path = "/cupos", produces = "application/json")
public class ControlCupos {
    @Autowired()
    private InterfaceCupos cupos;

    @GetMapping()
    public Object get_all_cupos() {
        try {
            return HttpRespuestas._200(cupos.findAll(), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @GetMapping("/{id}")
    public Object get_cupos(@PathVariable long id) {
        try {
            return HttpRespuestas._200(cupos.findById(id), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

    @PostMapping("/")
    public Object crear_cupo(@RequestBody EntityCupos body) {
        try {
            return HttpRespuestas._200(cupos.save(body), null);
        } catch (Exception e) {
            return HttpRespuestas._500(e.toString());
        }
    }

}