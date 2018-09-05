package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.LocalDateTime;
import java.util.List;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.excepcion.ParqueaderoException;

	
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

	// TODO verificar este método. Cómo lo pruebo?
	public Registro retirarVehiculo(Vehiculo vehiculo) {
		
		// Busca registro por la placa del vehiculo
		Registro registro = this.obtenerRegistroPorPlaca(vehiculo.getPlaca());
		
		if (registro == null) {
			throw new ParqueaderoException(REGISTRO_NO_ENCONTRADO);
		}
		
		// Retirar el vehiculo de la celda
		Celda celdaVehiculo = this.retirarVehiculoDeCelda(registro);
		
		// Remueve la celda y el registro de los arreglos de registros del parqueadero
		celdas.remove(celdaVehiculo);
		registros.remove(registro);
		
		return registro;
	}

	private Celda retirarVehiculoDeCelda(Registro registro) {
		Celda celdaVehiculo = registro.getCelda(); 
		celdaVehiculo.retirarVehiculo();
		return celdaVehiculo;
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
}
