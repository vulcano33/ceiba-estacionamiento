package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class Vigilante {
	
	private Parqueadero parqueadero;
	
	public Vigilante(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}
	
	/**
	 * Ingresa carro al parqueadero
	 * 
	 * @param carro
	 * @return
	 */
	public Registro ingresarCarro(Vehiculo vehiculo) {
		return parqueadero.ingresarVehiculo(vehiculo);
	}
}
