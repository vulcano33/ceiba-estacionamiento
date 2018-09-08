package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.ParqueaderoServicio;

@RestController
public class ParqueaderoControlador {
	
	@Autowired
	private ParqueaderoServicio repositorioServicio;
	
	@PostMapping("/registros")
	void ingresarRegistro(@RequestBody Registro registro) {
		repositorioServicio.ingresarRegistro(registro);
	}
	
	@GetMapping("/registros")
	public String saludar() {
		return "Consultando los registros...";
	}
	
}
