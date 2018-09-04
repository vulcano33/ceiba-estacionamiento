package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class Vehiculo {
	
	private String placa;
	private String cilindrajeCC;
	
	public Vehiculo(String placa, String cilindrajeCC) {
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCilindrajeCC() {
		return cilindrajeCC;
	}
}
