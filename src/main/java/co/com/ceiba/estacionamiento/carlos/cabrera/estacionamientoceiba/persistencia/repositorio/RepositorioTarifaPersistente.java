package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Tarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioTarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores.ConstructorTarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.TarifaEntidad;

/**
 * @author carlos.cabrera
 *
 */
@Component
public class RepositorioTarifaPersistente implements RepositorioTarifa {
	
	private RepositorioTarifaJPA repositorioTarifaJPA;
	
	public RepositorioTarifaPersistente(RepositorioTarifaJPA repositorioTarifaJPA) {
		this.repositorioTarifaJPA = repositorioTarifaJPA;
	}

	@Override
	public List<Tarifa> obtenerTarifas() {
		List<Tarifa> tarifas = new ArrayList<>();
		for (TarifaEntidad tarifaEntidad : repositorioTarifaJPA.findAll()) {
			Tarifa tarifa = ConstructorTarifa.convertirTarifaADominio(tarifaEntidad);
			tarifas.add(tarifa);
		}
		return tarifas;
	}
}
