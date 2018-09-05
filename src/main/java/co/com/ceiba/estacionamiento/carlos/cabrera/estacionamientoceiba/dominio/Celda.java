package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

/**
 * @author carlos.cabrera
 *
 */
public abstract class Celda {
	
	protected Vehiculo vehiculo;
	
	public abstract boolean ingresarVehiculo(Vehiculo vehiculo);
	
	public abstract void retirarVehiculo();
	
	public boolean estaLibre() {
		return vehiculo == null;
	}
}
