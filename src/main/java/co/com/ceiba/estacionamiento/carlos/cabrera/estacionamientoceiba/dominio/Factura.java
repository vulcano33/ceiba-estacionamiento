package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class Factura {
	private Registro registro;
	private Integer valorAPagar;

	public Factura(Registro registro) {
		super();
		this.registro = registro;
	}

	public Factura calcularValorAPagar() {
		// TODO Implementar este método (calcular el valor a pagar utilizando el objeto
		// registro)
		return this;
	}

	public Integer getValorAPagar() {
		return valorAPagar;
	}
}
