package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Carro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Moto;

public class VehiculoTestBuilder {
	
	private static final String PLACA = "QET443";
	private static final String CILINDRAJE = "1200";
	
	private String placa;
	private String cilindrajeCC;

	public VehiculoTestBuilder() {
		this.placa = PLACA;
		this.cilindrajeCC = CILINDRAJE;
	}

	public VehiculoTestBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}

	public VehiculoTestBuilder conCilindrajeCC(String cilindrajeCC) {
		this.cilindrajeCC = cilindrajeCC;
		return this;
	}

	public Carro buildCarro() {
		return new Carro(this.placa, this.cilindrajeCC);
	}
	
	public Moto buildMoto() {
		return new Moto(this.placa, this.cilindrajeCC);
	}

}