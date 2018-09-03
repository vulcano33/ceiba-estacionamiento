package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;

public class Registro {
	
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Vehiculo vehiculo;
	private Celda celda;
	private Integer identificador;
	
	public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo, Celda celda, Integer identificador) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.vehiculo = vehiculo;
		this.celda = celda;
		this.identificador = identificador;
	}
	
	public Registro() {
	}
	
	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}
	
	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}
	
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Celda getCelda() {
		return celda;
	}
	
	public void setCelda(Celda celda) {
		this.celda = celda;
	}
	
	public Integer getIdentificador() {
		return identificador;
	}
}
