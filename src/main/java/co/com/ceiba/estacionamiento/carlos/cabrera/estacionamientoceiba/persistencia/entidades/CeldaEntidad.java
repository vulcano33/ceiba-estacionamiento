package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author carlos.cabrera
 */
@Entity
@Table(name = "CELDA")
@NamedQueries({ @NamedQuery(name = "CeldaEntidad.findAll", query = "SELECT c FROM CeldaEntidad c") })
public class CeldaEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private Integer id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "celda")
	private Collection<RegistroEntidad> registroEntidadCollection;
	@JoinColumn(name = "TIPO", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private VehiculoEntidad tipo;

	public CeldaEntidad() {
	}

	public CeldaEntidad(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<RegistroEntidad> getRegistroEntidadCollection() {
		return registroEntidadCollection;
	}

	public void setRegistroEntidadCollection(Collection<RegistroEntidad> registroEntidadCollection) {
		this.registroEntidadCollection = registroEntidadCollection;
	}

	public VehiculoEntidad getTipo() {
		return tipo;
	}

	public void setTipo(VehiculoEntidad tipo) {
		this.tipo = tipo;
	}
}