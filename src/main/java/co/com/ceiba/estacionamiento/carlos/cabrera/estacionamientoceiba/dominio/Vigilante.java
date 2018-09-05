package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

public class Vigilante {
	
	public static final String NO_ESTA_AUTORIZADO_A_INGRESAR = "El vehículo no está autorizado a ingresar";
	private static final String LETRA_A = "a";
	private Parqueadero parqueadero;
	private Calendario calendario;
	
	public Vigilante(Parqueadero parqueadero, Calendario calendario) {
		this.parqueadero = parqueadero;
		this.calendario = calendario;
	}
	
	// ¿Cómo podría probar este método?
	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		if(ingresoDenegado(vehiculo.getPlaca())) {
			throw new ParqueaderoException(NO_ESTA_AUTORIZADO_A_INGRESAR);
		}
		return parqueadero.ingresarVehiculo(vehiculo);
	}

	private boolean ingresoDenegado(String placa) {
		boolean ingresoDenegado = true;
		if (placa.toLowerCase().startsWith(LETRA_A)) {
			
			DayOfWeek hoy = calendario.obtenerDiaDeHoy();
			
			if (hoy.equals(DayOfWeek.SUNDAY) || hoy.equals(DayOfWeek.MONDAY)) {
				ingresoDenegado = false;
			}
		}
		return ingresoDenegado;
	}
	
	public Registro retirarVehiculo(Vehiculo vehiculo) {
		return parqueadero.retirarVehiculo(vehiculo);
	}
}
