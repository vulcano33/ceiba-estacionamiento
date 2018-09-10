package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ParqueaderoControladorTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private static final String TIPO_VEHICULO = "tipoVehiculo";
	private static final String SERVICIO_PARQUEADERO_URL = "http://localhost:8080/registros";
	private static final String NUMERO_PLACA = "MKD443";
	private static final String PLACA = "placa";
	private static final Integer CILINDRAJECC = 1200;
	private static final LocalDateTime SEPT_9_7_AM = LocalDateTime.of(2018, Month.SEPTEMBER, 9, 9, 00);

	@Test
	public void obtenerVehiculosParqueadero() throws IOException {
		ResponseEntity<String> response = testRestTemplate.getForEntity(SERVICIO_PARQUEADERO_URL, String.class);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(response.getBody());
		JsonNode name = root.path(TIPO_VEHICULO);
		assertThat(name.asText(), notNullValue());
	}

	@Ignore
	@Test
	public void ingresarVehiculo() {
		RegistroVehiculo registroVehiculo = new RegistroVehiculoTestBuilder()
				.conTipoVehiculo(TipoVehiculo.CARRO.getTipo()).conPlaca(NUMERO_PLACA).conCilindrajeCC(CILINDRAJECC).build();
		ResponseEntity<RegistroVehiculo> response = testRestTemplate.postForEntity(SERVICIO_PARQUEADERO_URL,
				registroVehiculo, RegistroVehiculo.class);

		assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
	}

	@Test
	public void retirarVehiculo() {
		RegistroVehiculo registroSalida = new RegistroVehiculoTestBuilder()
				.conTipoVehiculo(TipoVehiculo.CARRO.getTipo()).conPlaca(NUMERO_PLACA).conCilindrajeCC(CILINDRAJECC)
				.conFechaEntrada(SEPT_9_7_AM).build();

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

		HttpHeaders headers = new HttpHeaders();
		Map<String, String> param = new HashMap<String, String>();
		param.put(PLACA, NUMERO_PLACA);
		HttpEntity<RegistroVehiculo> requestEntity = new HttpEntity<RegistroVehiculo>(registroSalida, headers);
		HttpEntity<RegistroVehiculo> response = restTemplate.exchange(SERVICIO_PARQUEADERO_URL, HttpMethod.PUT,
				requestEntity, RegistroVehiculo.class, param);
		
		RegistroVehiculo registroVehiculoObtenido = response.getBody();
		assertTrue(registroVehiculoObtenido.getPlaca().equals(registroSalida.getPlaca()));
	}

	@TestConfiguration
	static class Config {

		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().setConnectTimeout(1000).setReadTimeout(1000);
		}

	}
}
