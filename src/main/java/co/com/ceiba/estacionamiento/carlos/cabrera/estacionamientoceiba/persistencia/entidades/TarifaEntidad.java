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
	private int valorHora;
	@Column(name = "VALORDIA")
	private int valorDia;
	@Column(name = "VALORADICIONALCC")
	private Integer valorAdicionalCC;
	@JoinColumn(name = "TIPO", referencedColumnName = "ID", insertable = false, updatable = false)
	@OneToOne(optional = false)
	private VehiculoEntidad vehiculoEntidad;

	public TarifaEntidad() {
	}

	public TarifaEntidad(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public int getValorHora() {
		return valorHora;
	}

	public void setValorHora(int valorHora) {
		this.valorHora = valorHora;
	}

	public int getValorDia() {
		return valorDia;
	}

	public void setValorDia(int valorDia) {
		this.valorDia = valorDia;
	}

	public Integer getValorAdicionalCC() {
		return valorAdicionalCC;
	}

	public void setValorAdicionalCC(Integer valorAdicionalCC) {
		this.valorAdicionalCC = valorAdicionalCC;
	}

	public VehiculoEntidad getVehiculoEntidad() {
		return vehiculoEntidad;
	}

	public void setVehiculoEntidad(VehiculoEntidad vehiculoEntidad) {
		this.vehiculoEntidad = vehiculoEntidad;
	}
}