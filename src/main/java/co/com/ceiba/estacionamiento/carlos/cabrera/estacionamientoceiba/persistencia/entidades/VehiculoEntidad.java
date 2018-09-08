package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author carlos.cabrera
 */
@Entity
@Table(name = "TIPOVEHICULO")
@NamedQueries({ @NamedQuery(name = "VehiculoEntidad.findAll", query = "SELECT v FROM VehiculoEntidad v") })
public class VehiculoEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ID")
	private Integer id;
	@Column(name = "TIPO")
	private String tipo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
	private Collection<RegistroEntidad> registroEntidadCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo")
	private Collection<CeldaEntidad> celdaEntidadCollection;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "vehiculoEntidad")
	private TarifaEntidad tarifaEntidad;

	public VehiculoEntidad() {
	}

	public VehiculoEntidad(Integer id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Collection<RegistroEntidad> getRegistroEntidadCollection() {
		return registroEntidadCollection;
	}

	public void setRegistroEntidadCollection(Collection<RegistroEntidad> registroEntidadCollection) {
		this.registroEntidadCollection = registroEntidadCollection;
	}

	public Collection<CeldaEntidad> getCeldaEntidadCollection() {
		return celdaEntidadCollection;
	}

	public void setCeldaEntidadCollection(Collection<CeldaEntidad> celdaEntidadCollection) {
		this.celdaEntidadCollection = celdaEntidadCollection;
	}

	public TarifaEntidad getTarifaEntidad() {
		return tarifaEntidad;
	}

	public void setTarifaEntidad(TarifaEntidad tarifaEntidad) {
		this.tarifaEntidad = tarifaEntidad;
	}
}