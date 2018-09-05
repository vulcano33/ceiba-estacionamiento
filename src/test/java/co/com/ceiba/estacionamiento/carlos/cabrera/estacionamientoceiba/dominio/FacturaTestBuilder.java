package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

public class FacturaTestBuilder {
	
	private Registro registro;
	private Integer valorAPagar;
	
	public FacturaTestBuilder() {
	}

	public FacturaTestBuilder conRegistro(Registro registro) {
		this.registro = registro;
		return this;
	}
	
	public FacturaTestBuilder conValorAPagar(Integer valorAPagar) {
		this.valorAPagar = valorAPagar;
		return this;
	}
	

	public Factura build() {
		return new Factura(this.registro, this.valorAPagar);
	}
}
