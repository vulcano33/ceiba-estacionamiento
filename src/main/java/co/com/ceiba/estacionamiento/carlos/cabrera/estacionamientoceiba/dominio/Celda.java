package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public interface Celda {
	
	/**
	 * Determina si esta celda esta libre
	 * @return
	 */
	boolean estaLibre();
	
	/**
	 * Permite ingresar el vehículo recibido como parámetro a la celda
	 * @param vehiculo
	 * @return
	 */
	void ingresarVehiculo(Vehiculo vehiculo);
}
