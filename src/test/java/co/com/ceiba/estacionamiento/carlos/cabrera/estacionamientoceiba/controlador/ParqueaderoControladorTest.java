package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParqueaderoControladorTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private static final String TIPO_VEHICULO = "tipoVehiculo";

	@Test
	public void obtenerVehiculosParqueadero() throws IOException {
		ResponseEntity<String> response = testRestTemplate.getForEntity("/registros", String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.path(TIPO_VEHICULO);
		assertThat(name.asText(), notNullValue());
	}
}
