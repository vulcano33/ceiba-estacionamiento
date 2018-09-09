/**
 * 
 */
package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores.ConstructorFactura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.FacturaEntidad;

/**
 * @author carlos.cabrera
 *
 */
@Component
public class RepositorioFacturaPersistente implements RepositorioFactura {
	
	private RepositorioFacturaJPA repositorioFacturaJPA;
	
	public RepositorioFacturaPersistente(RepositorioFacturaJPA repositorioFacturaJPA) {
		this.repositorioFacturaJPA = repositorioFacturaJPA;
	}

	@Override
	public void ingresarFactura(Factura factura) {
		
		FacturaEntidad facturaEntidad = ConstructorFactura.convertirFacturaAEntidad(factura);
		repositorioFacturaJPA.save(facturaEntidad);
	}

	@Override
	public Factura obtenerFactura(Integer numeroFactura) {
		Factura factura = null;
		Optional<FacturaEntidad> facturaEntidadOp = repositorioFacturaJPA.findById(numeroFactura);
		if (facturaEntidadOp.isPresent()) {
			factura = ConstructorFactura.convertirFacturaADominio(facturaEntidadOp.get()); 
		}
		return factura;
	}

}
