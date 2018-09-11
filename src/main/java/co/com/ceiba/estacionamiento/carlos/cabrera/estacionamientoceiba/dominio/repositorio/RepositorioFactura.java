package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;

/**
 * @author carlos.cabrera
 *
 */
public interface RepositorioFactura {
	
	public void ingresarFactura(Factura factura);
	
	public Factura obtenerFactura(Integer numeroFactura);
	
}
