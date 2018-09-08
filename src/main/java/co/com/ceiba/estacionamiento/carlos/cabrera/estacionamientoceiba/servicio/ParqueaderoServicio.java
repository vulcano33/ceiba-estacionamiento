package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;

@Service
public class ParqueaderoServicio {

	@Autowired
	private RepositorioRegistro repositorioRegistro;

	public void ingresarRegistro(Registro registro) {
		repositorioRegistro.ingresarRegistro(registro);
	}
}
