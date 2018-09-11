package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

/**
 * @author carlos.cabrera
 *
 */
public abstract class Tarifa {
	
	protected Integer valorHora;
	protected Integer valorDia;
	protected Integer valorAdicionalCC;
	
	public Tarifa(Integer valorHora, Integer valorDia, Integer valorAdicionalCC) {
		super();
		this.valorHora = valorHora;
		this.valorDia = valorDia;
		this.valorAdicionalCC = valorAdicionalCC;
	}

	public abstract Factura generarFactura(Registro registro, Calendario calendario);
}
