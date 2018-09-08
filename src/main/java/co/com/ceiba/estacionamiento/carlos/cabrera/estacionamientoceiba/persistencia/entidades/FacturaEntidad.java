package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author carlos.cabrera
 */
@Entity
@Table(name = "FACTURA")
@NamedQueries({ @NamedQuery(name = "FacturaEntidad.findAll", query = "SELECT f FROM FacturaEntidad f") })
public class FacturaEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "VALOR")
	private Integer valor;
	@JoinColumn(name = "REGISTRO", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private RegistroEntidad registro;

	public FacturaEntidad() {
	}

	public FacturaEntidad(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public RegistroEntidad getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroEntidad registro) {
		this.registro = registro;
	}
}