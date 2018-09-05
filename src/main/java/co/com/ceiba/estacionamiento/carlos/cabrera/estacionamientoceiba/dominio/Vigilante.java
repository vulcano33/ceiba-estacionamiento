package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;
import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

public class Vigilante {
	
	public static final String NO_ESTA_AUTORIZADO_A_INGRESAR = "El vehículo no está autorizado a ingresar";
	private static final String LETRA_A = "a";
	private Parqueadero parqueadero;
	private Calendario calendario;
	private List<Tarifa> tarifas;
	
	public Vigilante(Parqueadero parqueadero, Calendario calendario, List<Tarifa> tarifas) {
		this.parqueadero = parqueadero;
		this.calendario = calendario;
		this.tarifas = tarifas;
	}
	
	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		Registro registro = null;

		if (vehiculo.getPlaca().toUpperCase().startsWith("A") && this.ingresoDenegado(vehiculo.getPlaca())) {
			throw new ParqueaderoException(NO_ESTA_AUTORIZADO_A_INGRESAR);
		}
		registro = parqueadero.ingresarVehiculo(vehiculo);
		
		return registro;
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
	
	// TODO Determinar si este método sobra, según las reglas del negocio
	public Registro retirarVehiculo(Vehiculo vehiculo) {
		return parqueadero.retirarVehiculo(vehiculo);
	}
	
	public Factura generarFactura(Vehiculo vehiculo) {
		Registro registro = parqueadero.retirarVehiculo(vehiculo);
		return this.calcularValorAPagar(registro);
	}

	private Factura calcularValorAPagar(Registro registro) {
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
