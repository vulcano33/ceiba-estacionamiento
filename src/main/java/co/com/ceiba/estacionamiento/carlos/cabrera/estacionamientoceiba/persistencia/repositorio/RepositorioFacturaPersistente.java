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
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;

/**
 * @author carlos.cabrera
 *
 */
@Component
public class RepositorioFacturaPersistente implements RepositorioFactura {
	
	private RepositorioFacturaJPA repositorioFacturaJPA;
	
	private RepositorioRegistroJPA repositorioRegistroJPA;
	
	public RepositorioFacturaPersistente(RepositorioFacturaJPA repositorioFacturaJPA, RepositorioRegistroJPA repositorioRegistroJPA) {
		this.repositorioFacturaJPA = repositorioFacturaJPA;
		this.repositorioRegistroJPA = repositorioRegistroJPA;
	}

	@Override
	public void ingresarFactura(Factura factura) {
		
		FacturaEntidad facturaEntidad = ConstructorFactura.convertirFacturaAEntidad(factura);
		RegistroEntidad registroEntidad = repositorioRegistroJPA.findByPlaca(factura.getRegistro().getVehiculo().getPlaca());
		facturaEntidad.setRegistro(registroEntidad);
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
