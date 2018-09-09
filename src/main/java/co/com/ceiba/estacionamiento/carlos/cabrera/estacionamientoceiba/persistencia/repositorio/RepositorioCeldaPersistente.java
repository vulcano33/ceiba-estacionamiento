package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioCelda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores.ConstructorCelda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.CeldaEntidad;

/**
 * @author carlos.cabrera
 *
 */
@Component
public class RepositorioCeldaPersistente implements RepositorioCelda {

	private RepositorioCeldaJPA repositorioCeldaJPA;

	public RepositorioCeldaPersistente(RepositorioCeldaJPA repositorioCeldaJPA) {
		this.repositorioCeldaJPA = repositorioCeldaJPA;
	}

	@Override
	public List<Celda> obtenerCeldas() {
		List<Celda> celdas = new ArrayList<>();

		for (CeldaEntidad celdaEntidad : repositorioCeldaJPA.findAll()) {
			Celda celda = ConstructorCelda.convertirCeldaADominio(celdaEntidad);
			celdas.add(celda);
		}
		return celdas;
	}
}
