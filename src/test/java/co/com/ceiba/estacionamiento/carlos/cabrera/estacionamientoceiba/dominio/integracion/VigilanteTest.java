package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.integracion;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Calendario;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Parqueadero;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Tarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.VehiculoTestBuilder;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vigilante;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

public class VigilanteTest {

	private static final int NUMERO_DE_CELDAS_DE_MOTOS = 10;
	private static final int NUMERO_DE_CELDAS_DE_CARROS = 20;
	private static final Integer VALOR_DIA_CARRO = 8000;
	private static final Integer VALOR_HORA_CARRO = 1000;
	private static final Integer VALOR_DIA_MOTO = 4000;
	private static final Integer VALOR_HORA_MOTO = 500;
	private static final Integer VALOR_ADICIONALCC = 2000;
	private static final String PLACA_EMPIEZA_POR_A = "ART546";
	private static final Integer DIAS_PERMANENCIA = 2;
	private static final Integer HORAS_RESTANTES_SUPERIOR_AL_LIMITE = 10;
	private static final Integer DIA_ADICIONAL = 1;
	private static final Integer CILINDRAJE_MENOR_500CC = 200;
	private static final Integer CILINDRAJE_MAYOR_500CC = 700;
	private static final int VALOR_ADICIONAL_MOTO_MAYOR_500CC = 2000;
	private List<Celda> celdas;
	private List<Registro> registros;
	private List<Tarifa> tarifas;

	@Before
	public void prepararDatos() {
		celdas = new ArrayList<>();
		registros = new ArrayList<>();
		tarifas = new ArrayList<>();
		this.configurarCeldasMotos();
		this.configurarCeldasCarros();
		this.configurarTarifas();
	}

	private void configurarTarifas() {
		tarifas.add(new TarifaCarro(VALOR_HORA_CARRO, VALOR_DIA_CARRO));
		tarifas.add(new TarifaMoto(VALOR_HORA_MOTO, VALOR_DIA_MOTO, VALOR_ADICIONALCC));

	}

	private void configurarCeldasCarros() {
		for (int indice = 1; indice < NUMERO_DE_CELDAS_DE_CARROS; indice++) {
			celdas.add(new CeldaCarro());
		}
	}

	private void configurarCeldasMotos() {
		for (int indice = 1; indice < NUMERO_DE_CELDAS_DE_MOTOS; indice++) {
			celdas.add(new CeldaMoto());
		}
	}

	@Test
	public void ingresarVehiculoTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);
		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.WEDNESDAY);
		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);
		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();

		// Act
		Registro registro = vigilante.ingresarVehiculo(vehiculo);

		// Asserts
		Assert.assertEquals(vehiculo.getPlaca(), registro.getVehiculo().getPlaca());
	}

	@Test(expected = ParqueaderoException.class)
	public void ingresarVPlacaANoDomingoOLunesTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.WEDNESDAY);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA_EMPIEZA_POR_A).buildCarro();

		// Act
		vigilante.ingresarVehiculo(vehiculo);

	}

	@Test
	public void ingresarVPlacaADomingoTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.SUNDAY);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA_EMPIEZA_POR_A).buildCarro();

		// Act
		Registro registro = vigilante.ingresarVehiculo(vehiculo);

		// Asserts
		Assert.assertEquals(vehiculo.getPlaca(), registro.getVehiculo().getPlaca());
	}

	@Test
	public void ingresarVPlacaALunesTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.MONDAY);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA_EMPIEZA_POR_A).buildCarro();

		// Act
		Registro registro = vigilante.ingresarVehiculo(vehiculo);

		// Asserts
		Assert.assertEquals(vehiculo.getPlaca(), registro.getVehiculo().getPlaca());

	}

	@Test(expected = ParqueaderoException.class)
	public void ingresarVehiculoYaExistenteTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();

		// Act
		Registro registro = vigilante.ingresarVehiculo(vehiculo);
		Assert.assertEquals(vehiculo.getPlaca(), registro.getVehiculo().getPlaca());

		vigilante.ingresarVehiculo(vehiculo);

	}

	@Test(expected = ParqueaderoException.class)
	public void retirarVehiculoQueNoExisteTest() {
		// Arrange
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();

		// Act
		vigilante.retirarVehiculo(vehiculo);
	}
	
	@Test
	public void retirarVehiculoCarroTest() {
		Parqueadero parqueadero = new Parqueadero(celdas, registros);
		
		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);
		
		Map<String, Integer> tiempoPermaneciaSimulado = new HashMap<>();
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA, DIAS_PERMANENCIA);
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_HORAS_RESTANTES, HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(any(), any())).thenReturn(tiempoPermaneciaSimulado);
		
		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);
		
		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();
		
		Registro registro = vigilante.ingresarVehiculo(vehiculo);
		Assert.assertEquals(vehiculo.getPlaca(), registro.getVehiculo().getPlaca());
		
		// Act
		Factura factura = vigilante.retirarVehiculo(vehiculo);
		Assert.assertEquals(registro.getVehiculo().getPlaca(), factura.getRegistro().getVehiculo().getPlaca());
		
		Integer diasPermanenciaTotales = tiempoPermaneciaSimulado.get(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA)
				+ DIA_ADICIONAL;
		Integer valorAPagarEsperado = diasPermanenciaTotales * VALOR_DIA_CARRO;
		
		Assert.assertEquals(valorAPagarEsperado, factura.getValorAPagar());
	}

	@Test
	public void retirarMotoMenos500CCTest() {
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);

		Map<String, Integer> tiempoPermaneciaSimulado = new HashMap<>();
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA, DIAS_PERMANENCIA);
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_HORAS_RESTANTES, HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(any(), any())).thenReturn(tiempoPermaneciaSimulado);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MENOR_500CC).buildMoto();

		Registro registro = vigilante.ingresarVehiculo(moto);
		Assert.assertEquals(moto.getPlaca(), registro.getVehiculo().getPlaca());

		// Act
		Factura factura = vigilante.retirarVehiculo(moto);
		Assert.assertEquals(registro.getVehiculo().getPlaca(), factura.getRegistro().getVehiculo().getPlaca());

		Integer diasPermanenciaTotales = tiempoPermaneciaSimulado.get(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA)
				+ DIA_ADICIONAL;
		Integer valorAPagarEsperado = diasPermanenciaTotales * VALOR_DIA_MOTO;

		Assert.assertEquals(valorAPagarEsperado, factura.getValorAPagar());
	}
	
	@Test
	public void retirarMotoMayor500CCTest() {
		Parqueadero parqueadero = new Parqueadero(celdas, registros);

		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);

		Map<String, Integer> tiempoPermaneciaSimulado = new HashMap<>();
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA, DIAS_PERMANENCIA);
		tiempoPermaneciaSimulado.put(Calendario.CLAVE_MAPA_HORAS_RESTANTES, HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(any(), any())).thenReturn(tiempoPermaneciaSimulado);

		Vigilante vigilante = new Vigilante(parqueadero, calendario, tarifas);

		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MAYOR_500CC).buildMoto();

		Registro registro = vigilante.ingresarVehiculo(moto);
		Assert.assertEquals(moto.getPlaca(), registro.getVehiculo().getPlaca());

		// Act
		Factura factura = vigilante.retirarVehiculo(moto);
		Assert.assertEquals(registro.getVehiculo().getPlaca(), factura.getRegistro().getVehiculo().getPlaca());

		Integer diasPermanenciaTotales = tiempoPermaneciaSimulado.get(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA)
				+ DIA_ADICIONAL;
		Integer valorAPagarEsperado = (diasPermanenciaTotales * VALOR_DIA_MOTO) + VALOR_ADICIONAL_MOTO_MAYOR_500CC;

		Assert.assertEquals(valorAPagarEsperado, factura.getValorAPagar());
	}
}
