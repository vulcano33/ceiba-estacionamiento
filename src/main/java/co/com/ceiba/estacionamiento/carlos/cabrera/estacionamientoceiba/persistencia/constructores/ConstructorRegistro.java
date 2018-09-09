package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.constructores;

import java.time.LocalDateTime;
import java.util.Date;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Celda;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.CeldaEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.VehiculoEntidad;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util.DateUtil;

/**
 * @author carlos.cabrera
 *
 */
public class ConstructorRegistro {
	
	private ConstructorRegistro() {
	}

	public static Registro convertirRegistroADominio(RegistroEntidad registroEntidad) {

		Vehiculo vehiculo = ConstructorVehiculo.convertirVehiculoADominio(registroEntidad.getTipo().getTipo(),
				registroEntidad.getPlaca(), registroEntidad.getCilindrajeCC());

		Celda celda = ConstructorCelda.convertirCeldaADominio(registroEntidad.getCelda());
		
		LocalDateTime fechaEntrada = DateUtil.getInstance().convertirDateALocalDateTime(registroEntidad.getFechaEntrada());

		return new Registro(fechaEntrada, vehiculo, celda);
	}
	
	public static RegistroEntidad convertirRegistroAEntidad(Registro registro) {
		
		VehiculoEntidad vehiculoEntidad = ConstructorVehiculo.convertirVehiculoAEntidad(registro.getVehiculo());
		
		CeldaEntidad celdaEntidad = ConstructorCelda.convertirCeldaAEntidad(registro.getCelda());
		Date fechaEntrada = DateUtil.getInstance().convertirLocalDateTimeADate(registro.getFechaEntrada());
		Date fechaSalida = DateUtil.getInstance().convertirLocalDateTimeADate(registro.getFechaSalida());
		
		RegistroEntidad registroEntidad = new RegistroEntidad();
		registroEntidad.setPlaca(registro.getVehiculo().getPlaca());
		registroEntidad.setCilindrajeCC(registro.getVehiculo().getCilindrajeCC());
		registroEntidad.setFechaEntrada(fechaEntrada);
		registroEntidad.setFechaSalida(fechaSalida);
		registroEntidad.setTipo(vehiculoEntidad);
		registroEntidad.setCelda(celdaEntidad);
		return registroEntidad; 
	}
}
