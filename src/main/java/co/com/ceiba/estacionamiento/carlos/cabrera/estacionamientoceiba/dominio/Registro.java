package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;

public class Registro {
	
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Vehiculo vehiculo;
	private Celda celda;
	
	public Registro(LocalDateTime fechaEntrada, Vehiculo vehiculo, Celda celda) {
		this.fechaEntrada = fechaEntrada;
		this.vehiculo = vehiculo;
		this.celda = celda;
	}
	
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public Celda getCelda() {
		return celda;
	}
}