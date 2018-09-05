package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.unitaria;

import static org.junit.Assert.assertEquals;
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
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.VehiculoTestBuilder;

public class TarifaMotoTest {

	private static final Integer VALOR_HORA = 500;
	private static final Integer VALOR_DIA = 4000;
	private static final Integer VALORADICIONALCC = 2000;
	private static final Integer DIAS_PERMANENCIA = 1;
	private static final Integer HORAS_RESTANTES_MENORES_LIMITE = 2;
	private static final Integer HORAS_RESTANTES_SUPERIOR_AL_LIMITE = 10;
	private static final Integer VALOR_A_PAGAR_HORAS_RESTANTES_MENOR_500CC = 5000;
	private static final Integer VALOR_A_PAGAR_DIA_ADICIONAL_MENOR_500CC = 8000;
	private static final Integer VALOR_A_PAGAR_HORAS_RESTANTES_MAYOR_500CC = 7000;
	private static final Integer VALOR_A_PAGAR_DIA_ADICIONAL_MAYOR_500CC = 10000;
	private static final Integer CILINDRAJE_MENOR_A_500CC = 200;
	private static final Integer CILINDRAJE_MAYOR_A_500CC = 700;
	private Tarifa tarifaMoto;

	@Before
	public void prepararDatos() {
		// Arrange
		tarifaMoto = new TarifaMoto(VALOR_HORA, VALOR_DIA, VALORADICIONALCC);
	}

	@Test
	public void generarFacturaMotoMenos9HorasTest() {

		// Arrange
		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MENOR_A_500CC).buildMoto();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(moto);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_MENORES_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_HORAS_RESTANTES_MENOR_500CC).build();

		// Act
		Factura factura = tarifaMoto.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}
	
	@Test
	public void generarFacturaMotoDiaAdicionalTest() {

		// Arrange
		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MENOR_A_500CC).buildMoto();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(moto);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_DIA_ADICIONAL_MENOR_500CC).build();

		// Act
		Factura factura = tarifaMoto.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}
	
	@Test
	public void genFacturaMotoMayor500CCMenos9HorasTest() {

		// Arrange
		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MAYOR_A_500CC).buildMoto();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(moto);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_MENORES_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_HORAS_RESTANTES_MAYOR_500CC).build();

		// Act
		Factura factura = tarifaMoto.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}
	
	@Test
	public void genFacturaMotoMayor500CCDiaAdicionalTest() {

		// Arrange
		Vehiculo moto = new VehiculoTestBuilder().conCilindrajeCC(CILINDRAJE_MAYOR_A_500CC).buildMoto();

		Registro registro = mock(Registro.class);
		when(registro.getVehiculo()).thenReturn(moto);

		Calendario calendario = mock(Calendario.class);
		HashMap<String, Integer> tiempoPermaneciaEsperado = new HashMap<>();
		tiempoPermaneciaEsperado.put("dias", DIAS_PERMANENCIA);
		tiempoPermaneciaEsperado.put("horasRestantes", HORAS_RESTANTES_SUPERIOR_AL_LIMITE);
		when(calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(), registro.getFechaSalida()))
				.thenReturn(tiempoPermaneciaEsperado);

		Factura facturaEsperada = new FacturaTestBuilder().conRegistro(registro)
				.conValorAPagar(VALOR_A_PAGAR_DIA_ADICIONAL_MAYOR_500CC).build();

		// Act
		Factura factura = tarifaMoto.generarFactura(registro, calendario);

		// Assert
		assertEquals(facturaEsperada.getValorAPagar(), factura.getValorAPagar());

	}

}
