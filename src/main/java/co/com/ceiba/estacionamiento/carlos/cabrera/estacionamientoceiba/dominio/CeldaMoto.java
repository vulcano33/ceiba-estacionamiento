package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaMoto extends Celda {

	public CeldaMoto(Integer numero) {
		super(numero);
	}

	@Override
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		boolean vehiculoIngresado = false;
		if (this.estaLibre() && vehiculo instanceof Moto) {
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
