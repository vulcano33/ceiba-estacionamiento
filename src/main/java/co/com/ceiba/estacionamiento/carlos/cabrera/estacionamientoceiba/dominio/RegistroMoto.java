package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;

public class RegistroMoto extends Registro {

	public RegistroMoto(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo, Celda celda,
			Integer identificador) {
		super(fechaEntrada, fechaSalida, vehiculo, celda, identificador);
	}

}
