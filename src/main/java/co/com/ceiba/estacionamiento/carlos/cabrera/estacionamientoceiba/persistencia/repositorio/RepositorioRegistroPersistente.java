package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores.ConstructorRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.DateUtil;

/**
 * @author carlos.cabrera
 *
 */
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
		RegistroEntidad registroEntidad = repositorioRegistroJPA.findByPlaca(registro.getVehiculo().getPlaca());
		Date fechaSalida = DateUtil.getInstance().convertirLocalDateTimeADate(registro.getFechaSalida());
		registroEntidad.setFechaSalida(fechaSalida);
		repositorioRegistroJPA.save(registroEntidad);
	}

	@Override
	public List<Registro> obtenerRegistrosActivos() {
		
		List<Registro> registros = new ArrayList<>();
		
		for (RegistroEntidad registroEntidad : repositorioRegistroJPA.findAll()) {
			if (registroEntidad != null) {
				Registro registro = ConstructorRegistro.convertirRegistroADominio(registroEntidad);
				registros.add(registro);
			}
		}
		return registros;
	}

}
