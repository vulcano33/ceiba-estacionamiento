package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;

public class RegistroCarro extends Registro {

	public RegistroCarro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo, Celda celda,
			Integer identificador) {
		super(fechaEntrada, fechaSalida, vehiculo, celda, identificador);
	}
	
	public RegistroCarro() {
	}
}
