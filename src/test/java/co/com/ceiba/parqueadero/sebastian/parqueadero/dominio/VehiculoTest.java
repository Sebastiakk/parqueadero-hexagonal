package co.com.ceiba.parqueadero.sebastian.parqueadero.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.EntityVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.InterfaceVehiculo;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.vehiculo.EntityVehiculo.TipoVehiculo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiculoTest {
	@Autowired()
	private InterfaceVehiculo vehiculo;
	private long id_vehiculo;

	public long getId_vehiculo() {
		return id_vehiculo;
	}

	public void setId_vehiculo(long id_vehiculo) {
		this.id_vehiculo = id_vehiculo;
	}

	@Test
	public void crear_moto() {
		try {
			String placa = "123-ABC";
			String modelo = "2017";
			String color = "Negro";
			String marca = "Yamaha";
			String poprietario = "Sebastian Ramirez";
			int cilintraje = 200;
			TipoVehiculo tipo_vehiculo = TipoVehiculo.Moto;
			EntityVehiculo data = new EntityVehiculo(placa, modelo, color, marca, cilintraje, tipo_vehiculo,
					poprietario);
			EntityVehiculo result = vehiculo.save(data);

			assertEquals(result.getPlaca(), placa);
			assertEquals(result.getModelo(), modelo);
			assertEquals(result.getColor(), color);
			assertEquals(result.getMarca(), marca);
			assertEquals(result.getCilintraje(), cilintraje);
			assertEquals(result.getTipo_vehiculo(), tipo_vehiculo);
			assertEquals(result.getPropietario(), poprietario);
			assertTrue(result.getId_vehiculo() > 0);
			setId_vehiculo(result.getId_vehiculo());
		} catch (Exception err) {
			fail();
		}
	}

	@Test
	public void crear_carro() {
		try {
			String placa = "321-DEF";
			String modelo = "2019";
			String color = "Negro";
			String marca = "Bugatti";
			int cilintraje = 1200;
			TipoVehiculo tipo_vehiculo = TipoVehiculo.Carro;
			String poprietario = "Sebastian Ramirez";
			EntityVehiculo data = new EntityVehiculo(placa, modelo, color, marca, cilintraje, tipo_vehiculo,
					poprietario);
			EntityVehiculo result = vehiculo.save(data);

			assertEquals(result.getPlaca(), placa);
			assertEquals(result.getModelo(), modelo);
			assertEquals(result.getColor(), color);
			assertEquals(result.getMarca(), marca);
			assertEquals(result.getCilintraje(), cilintraje);
			assertEquals(result.getTipo_vehiculo(), tipo_vehiculo);
			assertEquals(result.getPropietario(), poprietario);
			assertTrue(result.getId_vehiculo() > 0);
			setId_vehiculo(result.getId_vehiculo());

		} catch (Exception err) {
			fail();
		}
	}

	@Test
	public void get_vehiculos() {
		try {
			// Se crea el vehiculo
			crear_carro();
			// Se hace la consulta
			List<EntityVehiculo> result = vehiculo.findAll();
			// Se valida que el tamaño del resultado sea mayor a cero
			assertTrue((result.size() > 0) ? true : false);
		} catch (Exception err) {
			fail();
		}
	}

	@Test
	public void get_vehiculo() {
		try {
			// Se crea el vehiculo y se obtiene el id
			crear_carro();
			// Se crea el vehiculo nuevamente para y obtenemos el id
			long id_vehiculo = getId_vehiculo();
			// Se hace la consulta
			EntityVehiculo result = vehiculo.findById(id_vehiculo);
			// Se valida que el id del resultado sea igual al id del inser
			assertEquals(id_vehiculo, result.getId_vehiculo());
		} catch (Exception err) {
			fail();
		}
	}
}
