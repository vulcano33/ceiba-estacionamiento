package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;


public class CeldaMoto implements Celda {
	
	private Vehiculo moto;
	
	public CeldaMoto(Moto moto) {
		this.moto = moto;
	}

	@Override
	public boolean estaLibre() {
		return moto == null;
	}

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		// TODO Add implementation for this method
	}
}
