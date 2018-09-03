package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class Vehiculo {
	
	private String placa;
	private String cilindraje;
	
	public Vehiculo(String placa, String cilindraje) {
		this.placa = placa;
		this.cilindraje = cilindraje;
	}

	public String getPlaca() {
		return placa;
	}

	public String getCilindraje() {
		return cilindraje;
	}
}
