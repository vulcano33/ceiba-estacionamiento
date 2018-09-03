package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

public class Parqueadero {
	
	private static final String NO_HAY_CUPOS_PARA_CARROS = "Ya no hay cupos para carros disponibles";
	private List<CeldaCarro> celdasCarros;
	
	public Parqueadero() {
		super();
		
		// TODO Consultar a la BD las celdas disponibles
		celdasCarros = new ArrayList<>();
	}
	
	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		
		Registro registro = null;
		
		if(vehiculo instanceof Carro)
			registro = this.ingresarCarro(vehiculo);
		else
			registro = this.ingresarMoto(vehiculo);
		
		return registro;
	}

	private Registro ingresarCarro(Vehiculo vehiculo) {
		
		Registro registroEntrada = new RegistroCarro();
		
		Celda celdaCarroDisponible = this.obtenerCeldaCarroDisponible(celdasCarros);
		
		if (celdaCarroDisponible == null)
			throw new ParqueaderoException(NO_HAY_CUPOS_PARA_CARROS);
		
		celdaCarroDisponible.ingresarVehiculo(vehiculo);
		registroEntrada.setCelda(celdaCarroDisponible);
		registroEntrada.setVehiculo(vehiculo);
		registroEntrada.setFechaEntrada(LocalDateTime.now());
		
		// TODO Persistir el registro de entrada en la BD
		
		return registroEntrada;
	}
	
	private Celda obtenerCeldaCarroDisponible(List<CeldaCarro> celdasCarros) {

		Celda celdaDisponible = null;

		for (CeldaCarro celdaCarro : celdasCarros) {
			if (celdaCarro.estaLibre()) {
				celdaDisponible = celdaCarro;
				break;
			}
		}
		return celdaDisponible;
	}

	private Registro ingresarMoto(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		return null;
	}
}
