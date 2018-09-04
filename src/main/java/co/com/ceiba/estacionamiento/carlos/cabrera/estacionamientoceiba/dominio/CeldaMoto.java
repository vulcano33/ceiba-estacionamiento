package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaMoto extends Celda {

	@Override
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		boolean vehiculoIngresado = false;

		if (vehiculo instanceof Moto) {
			vehiculoIngresado = true;
		}

		return vehiculoIngresado;
	}
}
