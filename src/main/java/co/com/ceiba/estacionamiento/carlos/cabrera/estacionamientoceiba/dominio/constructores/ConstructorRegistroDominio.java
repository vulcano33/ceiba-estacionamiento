package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Carro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Moto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

public class ConstructorRegistroDominio {

	private ConstructorRegistroDominio() {
	}

	/**
	 * Convierte un registro vehiculo de la capa de servicio a un vehiculo del dominio
	 * @param registroVehiculo Objeto de registro de vehiculo que se usa en la capa de servicio
	 * @return
	 */
	public static Vehiculo convertirRegVehiculoSAVehiculoDominio(RegistroVehiculo registroVehiculo) {
		Vehiculo vehiculo = null;

		if (registroVehiculo != null) {
			if (registroVehiculo.getTipoVehiculo().equalsIgnoreCase(TipoVehiculo.CARRO.getTipo())) {
				vehiculo = new Carro(registroVehiculo.getPlaca(), registroVehiculo.getCilindrajeCC());
			} else {
				vehiculo = new Moto(registroVehiculo.getPlaca(), registroVehiculo.getCilindrajeCC());
			}
		}
		return vehiculo;
	}

	/**
	 * Convierte un objeto de tipo registro del dominio a un registro vehículo que se usa en la capa de servicio
	 * @param factura Objeto factura del dominio
	 * @return
	 */
	public static RegistroVehiculo convertirRegistroDominioARegVehiculo(Registro registro) {
		RegistroVehiculo registroVehiculo = null;
		if (registro != null) {
			
			registroVehiculo = new RegistroVehiculo();
			Vehiculo vehiculo = registro.getVehiculo();
			
			if (vehiculo instanceof Carro) {
				registroVehiculo.setTipoVehiculo(TipoVehiculo.CARRO.getTipo());
			} else {
				registroVehiculo.setTipoVehiculo(TipoVehiculo.MOTO.getTipo());
			}
			
			registroVehiculo.setFechaEntrada(registro.getFechaEntrada());
			registroVehiculo.setFechaSalida(registro.getFechaSalida());
			registroVehiculo.setPlaca(registro.getVehiculo().getPlaca());
			registroVehiculo.setCilindrajeCC(registro.getVehiculo().getCilindrajeCC());
		}
		return registroVehiculo;
	}
}
