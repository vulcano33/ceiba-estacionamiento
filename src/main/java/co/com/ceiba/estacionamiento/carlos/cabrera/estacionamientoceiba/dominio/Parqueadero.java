package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.util.List;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

// TODO implementar patr�n singleton en parqueadero (just need one instance)
public class Parqueadero {
	
	private static final String NO_HAY_CUPOS_PARA_CARROS = "Ya no hay cupos para carros disponibles";
	private List<Celda> celdas;
	private List<Registro> registros;
	
	public Parqueadero(List<Celda> celdas, List<Registro> registros) {
		this.celdas = celdas;
		this.registros = registros;
	}

	public Registro ingresarVehiculo(Vehiculo vehiculo) {

		Celda celdaVehiculo = this.ingresarVehiculoACelda(vehiculo);

		if (celdaVehiculo == null) {
			throw new ParqueaderoException(NO_HAY_CUPOS_PARA_CARROS);
		}
		
		Registro registro = new Registro(LocalDateTime.now(), vehiculo, celdaVehiculo);
		registros.add(registro);
	
		// TODO Persistir el registro de entrada en la BD
		return registro;
	}

	private Celda ingresarVehiculoACelda(Vehiculo vehiculo) {

		Celda celdaOcupadaPorVehiculo = null;

		for (Celda posibleCelda : celdas) {
			
			if (posibleCelda.ingresarVehiculo(vehiculo)) {
				celdaOcupadaPorVehiculo = posibleCelda;
				break;
			}
		}
		return celdaOcupadaPorVehiculo;
	}
}
