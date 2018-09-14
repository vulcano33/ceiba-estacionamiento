package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.ParqueaderoServicio;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;

/**
 * @author carlos.cabrera
 *
 */
@CrossOrigin(origins = {"http://localhost:4200" })
@RestController
public class ParqueaderoControlador {

	@Autowired
	private ParqueaderoServicio parqueaderoServicio;

	@PostMapping("/registros")
	@ResponseStatus(HttpStatus.CREATED)
	public RegistroVehiculo ingresarVehiculo(@RequestBody RegistroVehiculo registroVehiculo) {
		return parqueaderoServicio.ingresarVehiculo(registroVehiculo);
	}
	
	@GetMapping("/registros")
	public List<RegistroVehiculo> obtenerRegistrosActivos() {
		return parqueaderoServicio.obtenerRegistrosActivos();
	}
	
	@PutMapping(value = "/registros")
	@ResponseStatus(HttpStatus.OK)
	public RegistroVehiculo retirarVehiculo(@RequestBody RegistroVehiculo registroVehiculo) {
		
		return parqueaderoServicio.retirarVehiculo(registroVehiculo);
	}
}
