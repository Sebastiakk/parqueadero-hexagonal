package co.com.ceiba.parqueadero.sebastian.parqueadero.integracion;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import co.com.ceiba.parqueadero.sebastian.parqueadero.aplicacion.command.RegisterCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.Constantes;
import co.com.ceiba.parqueadero.sebastian.parqueadero.dominio.CuposBuildCommand;
import co.com.ceiba.parqueadero.sebastian.parqueadero.infraestrutura.api.ApiParqueadero;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@RunWith(SpringRunner.class)
public class IntegracionParqueaderoTest {
    @Autowired
    private ApiParqueadero parkingController;
    private MockMvc mockMvc;
    private CuposBuildCommand build;

    @Before
    public void setupMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(parkingController).build();
        this.build = new CuposBuildCommand();
    }

    @Test
    public void listar() throws Exception {
        // Arrange , Act y Assert
        mockMvc.perform(get(Constantes.PATH).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void crear() throws Exception {
        RegisterCommand registro = this.build.build();

        mockMvc.perform(post(Constantes.PATH).contentType(MediaType.APPLICATION_JSON).content(jsonToString(registro)))
                .andExpect(status().isOk());

    }

    private String jsonToString(RegisterCommand json) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(json);
    }

    @Test
    public void salidaDelVehiculo() throws Exception {
        // Act y Assert
        mockMvc.perform(put(Constantes.PATH + "/" + Constantes.PLACA).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
