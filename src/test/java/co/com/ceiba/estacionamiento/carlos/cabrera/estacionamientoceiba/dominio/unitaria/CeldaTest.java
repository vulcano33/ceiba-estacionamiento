package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.VehiculoTestBuilder;

public class CeldaTest {
	
	private static final String PLACA_CARRO = "QET443";
	private static final String CILINDRAJE_CARRO = "1200";
	private static final String PLACA_MOTO = "ORA29A";
	private static final String CILINDRAJE_MOTO = "600";
	private Celda celdaCarro;
	private Celda celdaMoto;
	private Vehiculo carro;
	private Vehiculo moto;
	
	@Before
	public void prepararDatos() { 
		// Arrange
		celdaCarro = new CeldaCarro();
		celdaMoto = new CeldaMoto();
		carro = new VehiculoTestBuilder().conPlaca(PLACA_CARRO).conCilindrajeCC(CILINDRAJE_CARRO).buildCarro();
		moto = new VehiculoTestBuilder().conPlaca(PLACA_MOTO).conCilindrajeCC(CILINDRAJE_MOTO).buildMoto();
	}
	
	@Test
	public void ingresarCarroACeldaCarroTest() {
		
		// Act
		boolean vehiculoIngresado = celdaCarro.ingresarVehiculo(carro);
		
		// Assert
		assertTrue(vehiculoIngresado);
	}
	
	@Test
	public void ingresarMotoACeldaCarroTest() {
		
		// Act
		boolean vehiculoIngresado = celdaCarro.ingresarVehiculo(moto);
		
		// Assert
		assertFalse(vehiculoIngresado);
	}
	
	@Test
	public void ingresarMotoACeldaMotoTest() {
		// Act
		boolean vehiculoIngresado = celdaMoto.ingresarVehiculo(moto);

		// Assert
		assertTrue(vehiculoIngresado);
	}
	
	@Test
	public void ingresarCarroACeldaMotoTest() {
		// Act
		boolean vehiculoIngresado = celdaMoto.ingresarVehiculo(carro);

		// Assert
		assertFalse(vehiculoIngresado);
	}
	
	@Test
	public void estaLibreTest() {
		assertTrue(celdaCarro.estaLibre());
		assertTrue(celdaMoto.estaLibre());
	}
	
	@Test
	public void noEstaLibreTest() {
		
		Celda celdaCarro = mock(CeldaCarro.class);
		Celda celdaMoto = mock(CeldaMoto.class); 
		when(celdaCarro.ingresarVehiculo(carro)).thenReturn(true);
		when(celdaMoto.ingresarVehiculo(moto)).thenReturn(true);
		assertFalse(celdaCarro.estaLibre());
		assertFalse(celdaMoto.estaLibre());
	}
}
