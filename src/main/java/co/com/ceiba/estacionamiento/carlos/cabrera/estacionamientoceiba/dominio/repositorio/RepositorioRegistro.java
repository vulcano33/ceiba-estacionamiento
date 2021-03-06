package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio;

import java.util.List;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;

/**
 * @author carlos.cabrera
 *
 */
public interface RepositorioRegistro {
	
	/**
	 * Permite ingresar un registro de un vehiculo al parqueadero 
	 * @param vehiculo
	 * @return
	 */
	void ingresarRegistro(Registro registro);
	
	/**
	 * Permite retirar un registro de un vehiculo del parqueadero
	 * @param vehiculo
	 * @return
	 */
	void retirarRegistro(Registro registro);
	
	/**
	 * Retorna una lista de los registros activos del parqueadero
	 * @return
	 */
	List<Registro> obtenerRegistrosActivos();
}
