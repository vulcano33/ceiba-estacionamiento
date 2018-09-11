package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

	
/**
 * @author carlos.cabrera
 *
 */
public class Parqueadero {
	public static final String NO_HAY_CUPOS_PARA_VEHICULOS = "Ya no hay cupos disponibles para vehiculos";
	public static final String REGISTRO_NO_ENCONTRADO = "No se encontró un registro asociado a la placa";
	private static final String YA_EXISTE_REGISTRO = "Ya existe un registro asociado a la placa";
	private List<Celda> celdas;
	private List<Registro> registros;
	
	public Parqueadero(List<Celda> celdas, List<Registro> registros) {
		this.celdas = celdas;
		this.registros = registros;
	}

	public Registro ingresarVehiculo(Vehiculo vehiculo) {
		
		if(this.obtenerRegistroPorPlaca(vehiculo.getPlaca()) != null) {
			throw new ParqueaderoException(YA_EXISTE_REGISTRO);
		}

		Celda celdaVehiculo = this.ingresarVehiculoACelda(vehiculo);
		if (celdaVehiculo == null) {
			throw new ParqueaderoException(NO_HAY_CUPOS_PARA_VEHICULOS);
		}

		Registro registro = new Registro(LocalDateTime.now(), vehiculo, celdaVehiculo);
		registros.add(registro);
	
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

	public Registro retirarVehiculo(Vehiculo vehiculo) {
		
		Registro registro = this.obtenerRegistroPorPlaca(vehiculo.getPlaca());
		
		if (registro == null) {
			throw new ParqueaderoException(REGISTRO_NO_ENCONTRADO);
		}
		
		this.retirarVehiculoDeCelda(registro);
		
		registro.setFechaSalida(LocalDateTime.now());
		registros.remove(registro);
		
		return registro;
	}

	private void retirarVehiculoDeCelda(Registro registro) {
		Celda celdaVehiculo = registro.getCelda(); 
		celdaVehiculo.retirarVehiculo();
	}

	private Registro obtenerRegistroPorPlaca(String placa) {
		
		Registro registroEncontrado = null;
		
		for (Registro registro : registros) {
			if (registro.getVehiculo().getPlaca().equalsIgnoreCase(placa)) {
				registroEncontrado = registro;
			}
		}
		return registroEncontrado;
	}

	public List<Registro> obtenerRegistros() {
		return registros;
	}
}
