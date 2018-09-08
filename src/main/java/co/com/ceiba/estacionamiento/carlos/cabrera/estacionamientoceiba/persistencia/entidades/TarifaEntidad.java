package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos.cabrera
 */
@Entity
@Table(name = "TARIFA")
@NamedQueries({ @NamedQuery(name = "TarifaEntidad.findAll", query = "SELECT t FROM TarifaEntidad t") })
public class TarifaEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "TIPO")
	private Integer tipo;
	@Column(name = "VALORHORA")
	private int valorhora;
	@Column(name = "VALORDIA")
	private int valordia;
	@Column(name = "VALORADICIONALCC")
	private Integer valoradicionalcc;
	@JoinColumn(name = "TIPO", referencedColumnName = "ID", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private VehiculoEntidad vehiculoEntidad;

	public TarifaEntidad() {
	}

	public TarifaEntidad(Integer tipo) {
		this.tipo = tipo;
	}

	public TarifaEntidad(Integer tipo, int valorhora, int valordia) {
		this.tipo = tipo;
		this.valorhora = valorhora;
		this.valordia = valordia;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public int getValorhora() {
		return valorhora;
	}

	public void setValorhora(int valorhora) {
		this.valorhora = valorhora;
	}

	public int getValordia() {
		return valordia;
	}

	public void setValordia(int valordia) {
		this.valordia = valordia;
	}

	public Integer getValoradicionalcc() {
		return valoradicionalcc;
	}

	public void setValoradicionalcc(Integer valoradicionalcc) {
		this.valoradicionalcc = valoradicionalcc;
	}

	public VehiculoEntidad getVehiculoEntidad() {
		return vehiculoEntidad;
	}

	public void setVehiculoEntidad(VehiculoEntidad vehiculoEntidad) {
		this.vehiculoEntidad = vehiculoEntidad;
	}
}