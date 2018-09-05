package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.unitaria;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.DayOfWeek;

import org.junit.Test;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Calendario;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Parqueadero;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.RegistroTestBuilder;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.VehiculoTestBuilder;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vigilante;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

/**
 * @author carlos.cabrera
 *
 */
public class VigilanteTest {

	private static final String PLACA_EMPIEZA_POR_A = "AET443";

	/**
	 * La placa del vehiculo empieza por A, pero el día no es Domingo o Lunes
	 */
	@Test(expected = ParqueaderoException.class)
	public void ingresarVPlacaANoDomingoOLunes() {

		// Arrange
		Parqueadero parqueadero = mock(Parqueadero.class);
		Calendario calendario = mock(Calendario.class);
		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA_EMPIEZA_POR_A).buildCarro();
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.TUESDAY);
		Vigilante vigilante = new Vigilante(parqueadero, calendario);

		// Act
		vigilante.ingresarVehiculo(vehiculo);
	}

	@Test
	public void ingresaarVehiculoPlacaADomingo() {

		// Arrange
		Vehiculo vehiculo = new VehiculoTestBuilder().conPlaca(PLACA_EMPIEZA_POR_A).buildCarro();
		Calendario calendario = mock(Calendario.class);
		when(calendario.obtenerDiaDeHoy()).thenReturn(DayOfWeek.SUNDAY);
		Parqueadero parqueadero = mock(Parqueadero.class);
		Registro registro = new RegistroTestBuilder().build();
		when(parqueadero.ingresarVehiculo(vehiculo)).thenReturn(registro);
		Vigilante vigilante = new Vigilante(parqueadero, calendario);

		registro = vigilante.ingresarVehiculo(vehiculo);

		assertNotNull(registro);
	}
}
