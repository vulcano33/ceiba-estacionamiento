package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.util.HashMap;

public class TarifaCarro extends Tarifa {
	
	private static final Integer DIA_ADICIONAL = 1;
	private static final Integer HORAS_LIMITE_DIA = 9;
	private Integer valorHora;
	private Integer valorDia;
	
	public TarifaCarro(Integer valorHora, Integer valorDia) {
		super();
		this.valorHora = valorHora;
		this.valorDia = valorDia;
	}

	@Override
	public Factura generarFactura(Registro registro, Calendario calendario) {
		
		Factura factura = null;
		
		if (registro.getVehiculo() instanceof Carro) {
			HashMap<String, Integer> tiempoPermanecia = calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(),
					registro.getFechaSalida());
			
			Integer diasDePermanencia = tiempoPermanecia.get("dias");
			Integer horasRestantesPermanencia = tiempoPermanecia.get("horasRestantes");
			
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
