package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Carro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Moto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.VehiculoEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;

public class ConstructorVehiculo {
	
	private ConstructorVehiculo() {
	}

	public static Vehiculo convertirVehiculoADominio(String tipo, String placa, Integer cilindrajeCC) {
		Vehiculo vehiculo = null;
		if(tipo.equalsIgnoreCase(TipoVehiculo.CARRO.getTipo())) {
			vehiculo = new Carro(placa, cilindrajeCC);
		} else {
			vehiculo = new Moto(placa, cilindrajeCC);
		}
		return vehiculo; 
	}

	public static VehiculoEntidad convertirVehiculoAEntidad(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = null;
		if(vehiculo instanceof Carro) {
			vehiculoEntidad = new VehiculoEntidad(TipoVehiculo.CARRO.getId(), TipoVehiculo.CARRO.getTipo());
		} else {
			vehiculoEntidad = new VehiculoEntidad(TipoVehiculo.MOTO.getId(), TipoVehiculo.MOTO.getTipo());
		}
		return vehiculoEntidad;
	}
}
