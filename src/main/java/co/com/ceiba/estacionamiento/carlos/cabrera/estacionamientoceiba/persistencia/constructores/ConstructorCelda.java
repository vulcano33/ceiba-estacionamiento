package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaCarro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.CeldaMoto;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.CeldaEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.TipoVehiculo;

public class ConstructorCelda {
	
	private ConstructorCelda() {
	}

	public static Celda convertirCeldaADominio(CeldaEntidad celdaEntidad) {
		 Celda celda = null;
		 
		 if (celdaEntidad.getTipo().getId().equals(TipoVehiculo.CARRO.getId())) {
			 celda = new CeldaCarro(celdaEntidad.getId());
		 } else {
			 celda = new CeldaMoto(celdaEntidad.getId());
		 }
		
		return celda;
	}

	public static CeldaEntidad convertirCeldaAEntidad(Celda celda) {
		return new CeldaEntidad(celda.getNumero());
	}

}
