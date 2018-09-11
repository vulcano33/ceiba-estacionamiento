package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.interfaces;

import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

/**
 * @author carlos.cabrera
 *
 */
public interface ServicioRegistroVehiculo {
	
	public List<RegistroVehiculo> obtenerRegistros();
	
	public RegistroVehiculo retirarRegistro(RegistroVehiculo registroVehiculo);
	
	public void ingresarRegistro(RegistroVehiculo registroVehiculo);
}
