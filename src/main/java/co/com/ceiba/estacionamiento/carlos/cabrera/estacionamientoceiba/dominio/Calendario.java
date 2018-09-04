package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Tiene métodos útiles para realizar cálculos con fechas
 * @author carlos.cabrera
 *
 */
public class Calendario {

	public DayOfWeek obtenerDiaDeHoy() {
		return LocalDate.now().getDayOfWeek();
	}
}
