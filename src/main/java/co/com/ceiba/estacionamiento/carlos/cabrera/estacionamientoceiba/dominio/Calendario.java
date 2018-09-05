package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

/**
 * Tiene métodos útiles para realizar cálculos con fechas
 * @author carlos.cabrera
 *
 */
public class Calendario {

	private static final Integer HORAS_DEL_DIA = 24;

	public DayOfWeek obtenerDiaDeHoy() {
		return LocalDate.now().getDayOfWeek();
	}

	/**
	 * Calcula el tiempo entre dos fechas
	 * @param fechaEntrada
	 * @param fechaSalida
	 * @return Map con el tiempo de permanencia así: un valor para días (clave dias) y otro para las horas restantes (clave horasRestantes)
	 */
	public HashMap<String, Integer> calcularTiempoEntreFechas(LocalDateTime fechaEntrada, LocalDateTime fechaSalida) {
		
		HashMap<String, Integer> tiempoDePermanencia = new HashMap<>(); 
		Long tiempoPermanenciaEnDias = ChronoUnit.DAYS.between(fechaEntrada, fechaSalida);
		Long tiempoPermanenciaEnHoras = ChronoUnit.HOURS.between(fechaEntrada, fechaSalida);
		Long horasRestantes = tiempoPermanenciaEnHoras % HORAS_DEL_DIA;
		tiempoDePermanencia.put("dias", tiempoPermanenciaEnDias.intValue());
		tiempoDePermanencia.put("horasRestantes", horasRestantes.intValue());
		return tiempoDePermanencia;
	}
}
