package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class CeldaCarro implements Celda {
	
	private Vehiculo carro; 
	
	public CeldaCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public boolean estaLibre() {
		return carro == null;
	}

	@Override
	public void ingresarVehiculo(Vehiculo vehiculo) {
		this.carro = vehiculo;
	}
}
