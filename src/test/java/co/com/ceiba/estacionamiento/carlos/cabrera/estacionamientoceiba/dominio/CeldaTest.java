package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.VehiculoTestBuilder;

public class CeldaTest {
	
	private static final String PLACA_CARRO = "QET443";
	private static final String CILINDRAJE_CARRO = "QET443";
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

}
