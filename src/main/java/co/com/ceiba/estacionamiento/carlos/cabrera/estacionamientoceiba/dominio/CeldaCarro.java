package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaCarro extends Celda {

	@Override
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		boolean vehiculoIngresado = false;
		if (vehiculo instanceof Carro) {
			this.vehiculo = vehiculo;
			vehiculoIngresado = true;
		}
		return vehiculoIngresado;
	}
}
