package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.util.Map;

public class TarifaCarro extends Tarifa {
	
	private static final Integer DIA_ADICIONAL = 1;
	private static final Integer HORAS_LIMITE_DIA = 9;
	
	public TarifaCarro(Integer valorHora, Integer valorDia, Integer valorAdicionalCC) {
		super(valorHora, valorDia, valorAdicionalCC);
	}

	@Override
	public Factura generarFactura(Registro registro, Calendario calendario) {
		
		Factura factura = null;
		
		if (registro.getVehiculo() instanceof Carro) {
			Map<String, Integer> tiempoPermanecia = calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(),
					registro.getFechaSalida());
			
			Integer diasDePermanencia = tiempoPermanecia.get(Calendario.CLAVE_MAPA_DIAS_PERMANENCIA);
			Integer horasRestantesPermanencia = tiempoPermanecia.get(Calendario.CLAVE_MAPA_HORAS_RESTANTES);
			
			Integer valorAPagar = 0;
			if (horasRestantesPermanencia > HORAS_LIMITE_DIA) {
				valorAPagar = (diasDePermanencia + DIA_ADICIONAL) * valorDia;
			} else {
				valorAPagar = diasDePermanencia * valorDia + horasRestantesPermanencia * valorHora;
			}
			factura = new Factura(registro, valorAPagar);
		}
		
		return factura;

	}
}
