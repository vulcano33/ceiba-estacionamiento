package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public abstract class Tarifa {
	public abstract Factura generarFactura(Registro registro, Calendario calendario);
}
