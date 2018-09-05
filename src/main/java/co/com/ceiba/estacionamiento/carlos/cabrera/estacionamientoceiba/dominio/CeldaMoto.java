package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaMoto extends Celda {

	@Override
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		boolean vehiculoIngresado = false;
		if (vehiculo instanceof Moto) {
			this.vehiculo = vehiculo;
			vehiculoIngresado = true;
		}
		return vehiculoIngresado;
	}

	@Override
	public void retirarVehiculo() {
		this.vehiculo = null;
	}
}
