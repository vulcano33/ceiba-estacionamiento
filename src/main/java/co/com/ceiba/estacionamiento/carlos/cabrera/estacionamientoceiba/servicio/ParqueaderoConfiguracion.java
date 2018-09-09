package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Calendario;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Parqueadero;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Tarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vigilante;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioCelda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioTarifa;

/**
 * Clase de configuración del parqueadero. Inicializa y carga todos los objetos
 * que necesita
 * 
 * @author carlos.cabrera
 *
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ParqueaderoConfiguracion {
	private Vigilante vigilante;
	private List<Registro> registrosActivos;
	private List<Celda> celdas;
	private List<Tarifa> tarifas;

	@Autowired
	private RepositorioRegistro repositorioRegistro;

	@Autowired
	private RepositorioCelda repositorioCelda;

	@Autowired
	private RepositorioTarifa repositorioTarifa;

	public Vigilante getVigilante() {
		return vigilante;
	}

	@PostConstruct
	public void inicializar() {
		
		this.consultarTarifas();
		this.consultarRegistrosActivos();
		this.consultarCeldas();
		
		Parqueadero parqueadero = new Parqueadero(celdas, registrosActivos);
		Calendario calendario = new Calendario();
		vigilante = new Vigilante(parqueadero, calendario, tarifas);
	}

	private void consultarTarifas() {
		tarifas = repositorioTarifa.obtenerTarifas();
	}

	private void consultarRegistrosActivos() {
		registrosActivos = repositorioRegistro.obtenerRegistrosActivos();
	}

	private void consultarCeldas() {

		Map<Integer, Celda> mapaCeldasTotales = new HashMap<>();

		for (Registro registro : registrosActivos) {
			Celda celdaAsociadaARegistro = registro.getCelda();
			mapaCeldasTotales.put(celdaAsociadaARegistro.getNumero(), celdaAsociadaARegistro);
		}

		for (Celda celda : repositorioCelda.obtenerCeldas()) {
			if (!mapaCeldasTotales.containsKey(celda.getNumero())) {
				mapaCeldasTotales.put(celda.getNumero(), celda);
			}
		}

		celdas = new ArrayList<>(mapaCeldasTotales.values());
	}
}
