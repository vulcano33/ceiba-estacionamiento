package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.time.Month;

public class RegistroBuilder {
	private static final LocalDateTime FECHA_ENTRADA = LocalDateTime.of(2018, Month.SEPTEMBER, 22, 8, 00);

	private LocalDateTime fechaEntrada;
	private Vehiculo vehiculo;
	private Celda celda;

	public RegistroBuilder() {
		this.fechaEntrada = FECHA_ENTRADA;
	}

	public RegistroBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}
	
	public RegistroBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public RegistroBuilder conCelda(Celda celda) {
		this.celda = celda;
		return this;
	}

	public Registro build() {
		return new Registro(this.fechaEntrada, this.vehiculo, this.celda);
	}
}
