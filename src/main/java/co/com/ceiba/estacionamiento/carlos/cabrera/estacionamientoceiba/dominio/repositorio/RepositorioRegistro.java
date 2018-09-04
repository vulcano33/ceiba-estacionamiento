package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio;

import java.util.List;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;

public interface RepositorioRegistro {
	
	/**
	 * Permite ingresar un registro de un vehiculo al parqueadero 
	 * @param vehiculo
	 * @return
	 */
	Registro ingresarRegistro(Registro registro);
	
	/**
	 * Permite retirar un vehiculo del parqueadero, retornando la factura con el valor a pagar
	 * @param vehiculo
	 * @return
	 */
	Registro retirarVehiculo(Registro registro);
	
	/**
	 * Retorna una lista de los registros activos del parqueadero
	 * @return
	 */
	List<Registro> listarRegistrosActivos();
}
