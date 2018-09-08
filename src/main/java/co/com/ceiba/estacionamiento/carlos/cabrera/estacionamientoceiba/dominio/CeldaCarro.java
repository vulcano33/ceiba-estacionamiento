package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaCarro extends Celda {

	public CeldaCarro(Integer numero) {
		super(numero);
	}

	@Override
	public boolean ingresarVehiculo(Vehiculo vehiculo) {
		boolean vehiculoIngresado = false;
		if (this.estaLibre() && vehiculo instanceof Carro) {
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
