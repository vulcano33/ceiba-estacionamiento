package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.FacturaEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;

public class ConstructorFactura {
	
	private ConstructorFactura() {
	}

	public static FacturaEntidad convertirFacturaAEntidad(Factura factura) {
		FacturaEntidad facturaEntidad = new FacturaEntidad();
		facturaEntidad.setValor(factura.getValorAPagar());
		RegistroEntidad registroEntidad = ConstructorRegistro.convertirRegistroAEntidad(factura.getRegistro());
		facturaEntidad.setRegistro(registroEntidad);
		return facturaEntidad;
	}

	public static Factura convertirFacturaADominio(FacturaEntidad facturaEntidad) {
		Registro registro = ConstructorRegistro.convertirRegistroADominio(facturaEntidad.getRegistro());
		Factura factura = new Factura(registro, facturaEntidad.getValor());
		return factura;
	}

}
