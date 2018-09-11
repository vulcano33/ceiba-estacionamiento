package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Tarifa;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.TarifaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.TarifaEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;

/**
 * @author carlos.cabrera
 *
 */
public class ConstructorTarifa {
	
	private ConstructorTarifa() {
	}

	public static Tarifa convertirTarifaADominio(TarifaEntidad tarifaEntidad) {
		Tarifa tarifa = null;
		if (tarifaEntidad.getTipo().equals(TipoVehiculo.CARRO.getId())) {
			tarifa = new TarifaCarro(tarifaEntidad.getValorHora(), tarifaEntidad.getValorDia(), tarifaEntidad.getValorAdicionalCC());
		} else {
			tarifa = new TarifaMoto(tarifaEntidad.getValorHora(), tarifaEntidad.getValorDia(), tarifaEntidad.getValorAdicionalCC());
		}
		
		return tarifa;
	}

}
