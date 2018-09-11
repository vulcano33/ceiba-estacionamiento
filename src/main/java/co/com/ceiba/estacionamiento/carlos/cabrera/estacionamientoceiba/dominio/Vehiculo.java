package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

/**
 * @author carlos.cabrera
 *
 */
public class Vehiculo {
	
	private String placa;
	private Integer cilindrajeCC;
	
	public Vehiculo(String placa, Integer cilindrajeCC) {
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
	}

	public String getPlaca() {
		return placa;
	}

	public Integer getCilindrajeCC() {
		return cilindrajeCC;
	}
}
