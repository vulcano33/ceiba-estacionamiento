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
	public Registro ingresarCarro(Carro carro) {
		return parqueadero.ingresarVehiculo(carro);
	}
}
