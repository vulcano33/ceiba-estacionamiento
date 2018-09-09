package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.ParqueaderoServicio;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.constructores.ConstructorRegistroServicio;

@RestController
public class ParqueaderoControlador {

	@Autowired
	private ParqueaderoServicio parqueaderoServicio;

	@PostMapping("/registros")
	void ingresarRegistro(@RequestBody RegistroVehiculo registroVehiculo) {

		Vehiculo vehiculo = ConstructorRegistroServicio.convertirRegistroServicio(registroVehiculo);
		parqueaderoServicio.ingresarVehiculo(vehiculo);
	}
}
