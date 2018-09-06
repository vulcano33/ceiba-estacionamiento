package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Tiene métodos útiles para realizar cálculos con fechas
 * @author carlos.cabrera
 *
 */
public class Calendario {

	public static final String CLAVE_MAPA_DIAS_PERMANENCIA = "dias";
	public static final String CLAVE_MAPA_HORAS_RESTANTES = "horasRestantes";
	private static final Integer HORAS_DEL_DIA = 24;

	public DayOfWeek obtenerDiaDeHoy() {
		return LocalDate.now().getDayOfWeek();
	}
	
	public LocalDateTime obtenerFechaYHoraActual() {
		return LocalDateTime.now();
	}

	/**
	 * Calcula el tiempo entre dos fechas
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @return Map con el tiempo de permanencia así: un valor para días (clave dias) y otro para las horas restantes (clave horasRestantes)
	 */
	public Map<String, Integer> calcularTiempoEntreFechas(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		
		Map<String, Integer> tiempoDePermanencia = new HashMap<>();

		Long tiempoPermanenciaEnDias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		Long tiempoPermanenciaEnHoras = ChronoUnit.HOURS.between(fechaEntrada, fechaSalida);
		Long horasRestantes = tiempoPermanenciaEnHoras % HORAS_DEL_DIA;
		
		tiempoDePermanencia.put(CLAVE_MAPA_DIAS_PERMANENCIA, tiempoPermanenciaEnDias.intValue());
		tiempoDePermanencia.put(CLAVE_MAPA_HORAS_RESTANTES, horasRestantes.intValue());
		
		return tiempoDePermanencia;
	}
}
