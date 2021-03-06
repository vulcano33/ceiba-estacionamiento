package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.interfaces.ServicioRegistroVehiculo;

/**
 * @author carlos.cabrera
 *
 */
@Component
@Service
public class ParqueaderoServicio {

	@Autowired
	private ServicioRegistroVehiculo servicioRegistroVehiculo;

	public RegistroVehiculo ingresarVehiculo(RegistroVehiculo registroVehiculo) {
		return servicioRegistroVehiculo.ingresarRegistro(registroVehiculo);
	}
	
	public RegistroVehiculo retirarVehiculo(RegistroVehiculo registroVehiculo) {
		return servicioRegistroVehiculo.retirarRegistro(registroVehiculo);
	}
	
	public List<RegistroVehiculo> obtenerRegistrosActivos() {
		return servicioRegistroVehiculo.obtenerRegistros();
	}
}
