package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores.ConstructorRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;

@Component
public class RepositorioRegistroPersistente implements RepositorioRegistro {

	private RepositorioRegistroJPA repositorioRegistroJPA;
	
	public RepositorioRegistroPersistente(RepositorioRegistroJPA repositorioJPA) {
		this.repositorioRegistroJPA = repositorioJPA;
	}

	@Override
	public void ingresarRegistro(Registro registro) {
		RegistroEntidad registroEntidad = ConstructorRegistro.convertirRegistroAEntidad(registro);
		repositorioRegistroJPA.save(registroEntidad);
	}

	@Override
	public void retirarRegistro(Registro registro) {
		RegistroEntidad registroEntidad = ConstructorRegistro.convertirRegistroAEntidad(registro);
		repositorioRegistroJPA.save(registroEntidad);
	}

	@Override
	public List<Registro> listarRegistrosActivos() {
		
		List<Registro> registros = new ArrayList<>();
		for (RegistroEntidad registroEntidad : repositorioRegistroJPA.findAll()) {
			Registro registro = ConstructorRegistro.convertirRegistroADominio(registroEntidad);
			registros.add(registro);
		}
		return registros;
	}

}
