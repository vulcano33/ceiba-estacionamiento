package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import java.time.LocalDateTime;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

/**
 * @author carlos.cabrera
 *
 */
public class RegistroVehiculoTestBuilder {

	private String tipoVehiculo;
	private String placa;
	private Integer cilindrajeCC;
	private LocalDateTime fechaEntrada;
	private LocalDateTime fechaSalida;
	private Integer valorAPagar;

	public RegistroVehiculoTestBuilder(String tipoVehiculo, String placa, Integer cilindrajeCC) {
		super();
		this.tipoVehiculo = tipoVehiculo;
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
	}

	public RegistroVehiculoTestBuilder() {
	}

	public RegistroVehiculoTestBuilder conTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	public RegistroVehiculoTestBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public RegistroVehiculoTestBuilder conCilindrajeCC(Integer cilindrajeCC) {
		this.cilindrajeCC = cilindrajeCC;
		return this;
	}

	public RegistroVehiculoTestBuilder conFechaEntrada(LocalDateTime fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
		return this;
	}

	public RegistroVehiculoTestBuilder conFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		return this;
	}

	public RegistroVehiculoTestBuilder conValorAPagar(Integer valorAPagar) {
		this.valorAPagar = valorAPagar;
		return this;
	}

	public RegistroVehiculo build() {
		return new RegistroVehiculo(this.tipoVehiculo, this.placa, this.cilindrajeCC, this.fechaEntrada,
				this.fechaSalida, this.valorAPagar);
	}

}
