package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Calendario;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.FacturaTestBuilder;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Tarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.VehiculoTestBuilder;

public class TarifaCarroTest {

	private static final Integer VALOR_HORA = 1000;
	private static final Integer VALOR_DIA = 8000;
	private static final Integer DIAS_PERMANENCIA = 1;
	private static final Integer HORAS_RESTANTES_MENORES_LIMITE = 2;
	private static final Integer HORAS_RESTANTES_SUPERIOR_AL_LIMITE = 10;
	private static final Integer VALOR_A_PAGAR_HORAS_RESTANTES = 10000;
	private static final Integer VALOR_A_PAGAR_DIA_ADICIONAL = 16000;
	private Tarifa tarifaCarro;

	@Before
	public void prepararDatos() {
		// Arrange
		tarifaCarro = new TarifaCarro(VALOR_HORA, VALOR_DIA);
	}
	
	@Test
	public void generarFacturaCarroParaMotoTest() {
		// Arrange
		Vehiculo moto = new VehiculoTestBuilder().buildMoto();

		Calendario calendario = mock(Calendario.class);
		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(moto);

		// Act
		Factura factura = tarifaCarro.generarFactura(registro, calendario);

		// Assert
		assertNull(factura);
	}

	@Test
	public void generarFacturaCarroHorasRestantesTest() {

		// Arrange
		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(vehiculo);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_MENORES_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_HORAS_RESTANTES).build();

		// Act
		Factura factura = tarifaCarro.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}
	
	@Test
	public void generarFacturaCarroDiaAdicionalTest() {

		// Arrange
		Vehiculo vehiculo = new VehiculoTestBuilder().buildCarro();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(vehiculo);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_DIA_ADICIONAL).build();

		// Act
		Factura factura = tarifaCarro.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}
}
