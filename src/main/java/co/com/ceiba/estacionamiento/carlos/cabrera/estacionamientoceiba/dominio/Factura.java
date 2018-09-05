package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class Factura {
	private Registro registro;
	private Integer valorAPagar;

	public Factura(Registro registro, Integer valorAPagar) {
		this.registro = registro;
		this.valorAPagar = valorAPagar;
	}

	public Integer getValorAPagar() {
		return valorAPagar;
	}
	
	public Registro getRegistro() {
		return registro;
	}
}
