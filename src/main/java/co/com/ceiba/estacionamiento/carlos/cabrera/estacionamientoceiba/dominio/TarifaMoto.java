package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

import java.util.Map;

public class TarifaMoto extends Tarifa {

	private static final Integer DIA_ADICIONAL = 1;
	private static final Integer HORAS_LIMITE_DIA = 9;
	private Integer valorHora;
	private Integer valorDia;
	private Integer valorAdicionalCC;

	public TarifaMoto(Integer valorHora, Integer valorDia, Integer valorAdicionalCC) {
		super();
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.valorAdicionalCC = valorAdicionalCC;
	}

	private boolean aplicaTarifaMoto500CC(Vehiculo vehiculo) {
		boolean aplicaTarifaAdicional = false;
		if (vehiculo.getCilindrajeCC() > 500) {
			aplicaTarifaAdicional = true;
		}
		return aplicaTarifaAdicional;
	}

	@Override
	public Factura generarFactura(Registro registro, Calendario calendario) {
		
		Factura factura = null;
		
		if (registro.getVehiculo() instanceof Moto) {
			Map<String, Integer> tiempoPermanecia = calendario.calcularTiempoEntreFechas(registro.getFechaEntrada(),
					registro.getFechaSalida());
			
			Integer diasDePermanencia = tiempoPermanecia.get("dias");
			Integer horasRestantesPermanencia = tiempoPermanecia.get("horasRestantes");
			
			Integer valorAPagar = 0;
			if (horasRestantesPermanencia > HORAS_LIMITE_DIA) {
				valorAPagar = (diasDePermanencia + DIA_ADICIONAL) * valorDia;
			} else {
				valorAPagar = diasDePermanencia * valorDia + horasRestantesPermanencia * valorHora;
			}
			
			if (aplicaTarifaMoto500CC(registro.getVehiculo())) {
				valorAPagar += valorAdicionalCC;
			}
			factura = new Factura(registro, valorAPagar);
		}
		
		return factura;
	}
}
