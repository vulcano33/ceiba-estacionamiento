package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

import java.time.LocalDateTime;

public class RegistroVehiculo {

	private String tipoVehiculo;
	private String placa;
	private Integer cilindrajeCC;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Integer valorAPagar;

	public RegistroVehiculo(String tipoVehiculo, String placa, Integer cilindrajeCC, LocalDateTime fechaEntrada,
			LocalDateTime fechaSalida, Integer valorAPagar) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valorAPagar = valorAPagar;
	}

	public RegistroVehiculo() {
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

	public LocalDateTime getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Integer getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(Integer valorAPagar) {
		this.valorAPagar = valorAPagar;
	}
}
