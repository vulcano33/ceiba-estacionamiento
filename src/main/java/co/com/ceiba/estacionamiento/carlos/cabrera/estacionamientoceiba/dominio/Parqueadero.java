package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.util.List;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

	
public class Parqueadero {
	private static final String NO_HAY_CUPOS_PARA_VEHICULOS = "Ya no hay cupos disponibles para vehiculos";
	private List<Celda> celdas;
	private List<Registro> registros;
	
	public Parqueadero(List<Celda> celdas, List<Registro> registros) {
		this.celdas = celdas;
		this.registros = registros;
	}

	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		// TODO> Cómo probar este método?
		
		Celda celdaVehiculo = this.ingresarVehiculoACelda(vehiculo);

		if (celdaVehiculo == null) {
			throw new ParqueaderoException(NO_HAY_CUPOS_PARA_VEHICULOS);
		}
		
		Registro registro = new Registro(LocalDateTime.now(), vehiculo, celdaVehiculo);
		registros.add(registro);
	
		// TODO Persistir el registro de entrada en la BD
		return registro;
	}

	private Celda ingresarVehiculoACelda(Vehiculo vehiculo) {

		Celda celdaOcupadaPorVehiculo = null;

		for (Celda posibleCelda : celdas) {
			
			// TODO
			// Debería preguntar si están libres antes de intentar ingresar el vehículo?
			// La lista de celdas al crear el parqueadero, es la lista de carros y motos o
			// el parqueadero tiene dos listas de celdas, una de carros y una de motos?
			
			if (posibleCelda.ingresarVehiculo(vehiculo)) {
				celdaOcupadaPorVehiculo = posibleCelda;
				break;
			}
		}
		return celdaOcupadaPorVehiculo;
	}
}
