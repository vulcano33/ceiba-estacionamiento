package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Carro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Moto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

public class ConstructorRegistroServicio {

	private static final String CARRO = "CARRO";
	private static final String MOTO = "MOTO";
	
	private ConstructorRegistroServicio() {
	}

	public static Vehiculo convertirRegistroServicio(RegistroVehiculo registroVehiculo) {

		Vehiculo vehiculo = null;

		if (registroVehiculo.getTipoVehiculo().equalsIgnoreCase(CARRO)) {
			vehiculo = new Carro(registroVehiculo.getPlaca(), registroVehiculo.getCilindrajeCC());
		}
		if (registroVehiculo.getTipoVehiculo().equalsIgnoreCase(MOTO)) {
			vehiculo = new Moto(registroVehiculo.getPlaca(), registroVehiculo.getCilindrajeCC());
		}

		return vehiculo;
	}

}
