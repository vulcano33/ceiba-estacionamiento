package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParqueaderoControladorTest {

	private static final String PATH_REGISTROS = "/registros";
	private static final String TIPO_VEHICULO = "tipoVehiculo";
	private static final String NUMERO_PLACA = "MKD443";
	private static final String PLACA = "placa";
	private static final Integer CILINDRAJECC = 1200;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void obtenerVehiculosParqueadero() throws IOException {
		ResponseEntity<String> response = testRestTemplate.getForEntity(PATH_REGISTROS, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.path(TIPO_VEHICULO);
		assertThat(name.asText(), notNullValue());
	}

	@Test
	public void ingresarVehiculo() {
		this.probarIngresoVehiculo();
	}

	private void probarIngresoVehiculo() {

		RegistroVehiculo registroVehiculo = new RegistroVehiculoTestBuilder()
				.conTipoVehiculo(TipoVehiculo.CARRO.getTipo()).conPlaca(NUMERO_PLACA).conCilindrajeCC(CILINDRAJECC)
				.build();
		ResponseEntity<RegistroVehiculo> response = testRestTemplate.postForEntity(PATH_REGISTROS, registroVehiculo,
				RegistroVehiculo.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.CREATED));
	}

	@Test
	public void retirarVehiculo() {

		this.probarIngresoVehiculo();

		RegistroVehiculo registroSalida = new RegistroVehiculoTestBuilder()
				.conTipoVehiculo(TipoVehiculo.CARRO.getTipo()).conPlaca(NUMERO_PLACA).build();

		Map<String, String> param = new HashMap<String, String>();
		param.put(PLACA, NUMERO_PLACA);
		HttpEntity<RegistroVehiculo> requestEntity = new HttpEntity<RegistroVehiculo>(registroSalida, null);
		HttpEntity<RegistroVehiculo> response = testRestTemplate.exchange(PATH_REGISTROS, HttpMethod.PUT, requestEntity,
				RegistroVehiculo.class, param);

		RegistroVehiculo registroVehiculoObtenido = response.getBody();
		Assert.assertTrue(registroVehiculoObtenido.getPlaca().equals(registroSalida.getPlaca()));

	}

}
