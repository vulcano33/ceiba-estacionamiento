package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

/**
 * @author carlos.cabrera
 *
 */
public abstract class Celda {
	
	private Integer numero;
	
	protected Vehiculo vehiculo;
	
	public Celda(Integer numero) {
		this.numero = numero;
	}
	
	public abstract boolean ingresarVehiculo(Vehiculo vehiculo);
	
	public abstract void retirarVehiculo();
	
	public boolean estaLibre() {
		return vehiculo == null;
	}
	
	public Integer getNumero() {
		return numero;
	}
}
