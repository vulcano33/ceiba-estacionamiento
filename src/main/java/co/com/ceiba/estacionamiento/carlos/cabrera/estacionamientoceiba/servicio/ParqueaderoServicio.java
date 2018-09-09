package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vigilante;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;

@Component
@Service
public class ParqueaderoServicio {

	@Autowired
	private RepositorioRegistro repositorioRegistro;
	
	@Autowired
	private ParqueaderoConfiguracion configParqueadero;

	public void ingresarVehiculo(Vehiculo vehiculo) {
		
		Vigilante vigilante = configParqueadero.getVigilante();
		Registro registro = vigilante.ingresarVehiculo(vehiculo);
		repositorioRegistro.ingresarRegistro(registro);
		
	}
}
