package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase con métodos de utilidad para conversiones de fechas
 * @author carlos.cabrera
 *
 */
public class DateUtil {
	
	private static DateUtil instance;
	
	private DateUtil() {
	}
	
	public static DateUtil getInstance() {
		if (instance == null)
			instance = new DateUtil();
		return instance;
	}
	
	public LocalDate convertirDateALocalDate(Date fecha) {
		
		LocalDate resultado = null;
		if (fecha != null) {
			Instant instant = fecha.toInstant();
			resultado = instant.atZone(ZoneId.systemDefault()).toLocalDate();
			
		}
		return resultado;
	}
	
	public Date convertirLocalDateADate(LocalDate fecha) {
		
		Date resultado = null;
		if (fecha != null)
			resultado = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return resultado;
	}
	
	public Date convertirLocalDateTimeADate(LocalDateTime fechaEntrada) {
		Date fechaSalida = null;
		
		if (fechaEntrada != null) {
			fechaSalida = java.util.Date
				      .from(fechaEntrada.atZone(ZoneId.systemDefault())
				    	      .toInstant()); 
		}
		
		return fechaSalida;
	}
	
	public LocalDateTime convertirDateALocalDateTime(Date fechaEntrada) {
		return fechaEntrada.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}