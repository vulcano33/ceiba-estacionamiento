package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio;

/**
 * @author carlos.cabrera
 *
 */
public class TarifaTestBuilder {

	private static final Integer VALOR_HORA = 500;
	private static final Integer VALOR_DIA = 1200;
	private static final Integer VALOR_ADICIONAL = 1200;

	private Integer valorHora;
	private Integer valorDia;
	private Integer valorAdicional;

	public TarifaTestBuilder() {
		this.valorHora = VALOR_HORA;
		this.valorDia = VALOR_DIA;
		this.valorAdicional = VALOR_ADICIONAL;
	}

	public TarifaMoto build() {
		return new TarifaMoto(this.valorHora, this.valorDia, this.valorAdicional);
	}

}
