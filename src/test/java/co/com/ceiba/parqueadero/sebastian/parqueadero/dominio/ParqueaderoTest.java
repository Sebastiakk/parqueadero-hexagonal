package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.EntityParqueadero;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.parqueadero.InterfaceParqueadero;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParqueaderoTest {
	@Autowired()
	private InterfaceParqueadero parqueadero;
	private long resultado_id;

	public long getResultado_id() {
		return this.resultado_id;
	}

	public void setResultado_id(long resultado_id) {
		this.resultado_id = resultado_id;
	}

	@Test
	public void crear_parqueadero() {
		try {
			String nombre_parquedero = "Parqueo donde sebas";
			EntityParqueadero data = new EntityParqueadero(nombre_parquedero);
			EntityParqueadero result = parqueadero.save(data);
			assertEquals(nombre_parquedero, result.getNombre());
			assertTrue(result.getid_parqueadero() > 0);
			// Se guarda el id del resultado para poximas pruebas
			setResultado_id(result.getid_parqueadero());
		} catch (Exception err) {
			fail();
		}
	}

	@Test
	public void get_parquederos() {
		try {
			// Se crea el parquedero
			crear_parqueadero();
			// Se hace la consulta
			List<EntityParqueadero> result = parqueadero.findAll();
			// Se valida que el tamaño del resultado sea mayor a cero
			assertTrue((result.size() > 0) ? true : false);
		} catch (Exception err) {
			fail();
		}
	}

	@Test
	public void get_parquedero() {
		try {
			// Se crea el parquedero y se obtiene el id
			crear_parqueadero();
			// Se crea el parquedero nuevamente para y obtenemos el id
			long id_parqueadero = getResultado_id();
			// Se hace la consulta
			EntityParqueadero result = parqueadero.findById(id_parqueadero);
			// Se valida que el id del resultado sea igual al id del inser
			assertEquals(id_parqueadero, result.getid_parqueadero());
		} catch (Exception err) {
			fail();
		}
	}
}
