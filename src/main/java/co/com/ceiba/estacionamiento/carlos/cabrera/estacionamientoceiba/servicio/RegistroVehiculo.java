package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

/**
 * Permite la interacción con los clientes que consumen el servicio web
 * 
 * @author carlos.cabrera
 *
 */
public class RegistroVehiculo {

	private String tipoVehiculo;
	private String placa;
	private Integer cilindrajeCC;

	public RegistroVehiculo() {
	}

	public RegistroVehiculo(String tipoVehiculo, String placa, Integer cilindrajeCC) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getCilindrajeCC() {
		return cilindrajeCC;
	}

	public void setCilindrajeCC(Integer cilindrajeCC) {
		this.cilindrajeCC = cilindrajeCC;
	}
}
