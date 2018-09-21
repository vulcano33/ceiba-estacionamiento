package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;
import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

/**
 * @author carlos.cabrera
 *
 */
public class Vigilante {
	
	public static final String NO_ESTA_AUTORIZADO_A_INGRESAR = "El vehículo no está autorizado a ingresar";	
	public static final String REGISTRO_SIN_PLACA = "Está intentando crear un registro sin especificar la placa. Por favor ingrese una placa.";
	public static final String REGISTRO_SIN_CILINDRAJE = "Está intentando crear un registro sin especificar el cilindraje. Por favor ingrese un valor para el cilindraje.";
	public static final String TIPO_VEHICULO_NO_SOPORTADO = "El tipo de vehículo que se ha recibido no está soportado";
	private static final String LETRA_A = "a";
	public static final Integer SIN_CILINDRAJE = 0;
	private Parqueadero parqueadero;
	private Calendario calendario;
	private List<Tarifa> tarifas;
	
	public Vigilante(Parqueadero parqueadero, Calendario calendario, List<Tarifa> tarifas) {
		this.parqueadero = parqueadero;
		this.calendario = calendario;
		this.tarifas = tarifas;
	}
	
	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		
		if (vehiculo == null) {
			throw new ParqueaderoException(TIPO_VEHICULO_NO_SOPORTADO);
		}
		
		if (vehiculo.getPlaca() == null || vehiculo.getPlaca().equals("")) {
			throw new ParqueaderoException(REGISTRO_SIN_PLACA);
		}
		
		if (vehiculo.getCilindrajeCC() == null || vehiculo.getCilindrajeCC() == SIN_CILINDRAJE) {
			throw new ParqueaderoException(REGISTRO_SIN_CILINDRAJE);
		}
		
		if (vehiculo.getPlaca().toLowerCase().startsWith(LETRA_A) && this.ingresoDenegado()) {
			throw new ParqueaderoException(NO_ESTA_AUTORIZADO_A_INGRESAR);
		}
		
		return parqueadero.ingresarVehiculo(vehiculo);
	}

	private boolean ingresoDenegado() {
		boolean ingresoDenegado = true;

		DayOfWeek hoy = calendario.obtenerDiaDeHoy();

		if (hoy.equals(DayOfWeek.SUNDAY) || hoy.equals(DayOfWeek.MONDAY)) {
			ingresoDenegado = false;
		}
		return ingresoDenegado;
	}

	public Registro retirarVehiculo(Vehiculo vehiculo) {
		return parqueadero.retirarVehiculo(vehiculo);
	}
	
	public Factura generarFactura(Registro registro) {
		Factura factura = null;
		for (Tarifa tarifa : tarifas) {
			Factura posibleFactura = tarifa.generarFactura(registro, calendario);
			if(posibleFactura != null) {
				factura = posibleFactura;
			}
		}
		return factura;
	}
	
	public List<Registro> obtenerRegistros() {
		return parqueadero.obtenerRegistros();
	}
}
