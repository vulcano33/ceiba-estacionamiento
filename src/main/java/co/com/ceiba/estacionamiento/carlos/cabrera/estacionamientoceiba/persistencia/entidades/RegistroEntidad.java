package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "REGISTRO")
@NamedQueries({ @NamedQuery(name = "RegistroEntidad.findAll", query = "SELECT r FROM RegistroEntidad r") })
public class RegistroEntidad implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "PLACA")
	private String placa;
	@Column(name = "CILINDRAJECC")
	private int cilindrajeCC;
	@Column(name = "FECHAENTRADA")
	private Date fechaEntrada;
	@Column(name = "FECHASALIDA")
	private Date fechaSalida;
	@JoinColumn(name = "CELDA", referencedColumnName = "ID")
	@ManyToOne
	private CeldaEntidad celda;
	@JoinColumn(name = "TIPO", referencedColumnName = "ID")
	@ManyToOne
	private VehiculoEntidad tipo;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "registro")
	private Collection<FacturaEntidad> facturaEntidadCollection;

	public RegistroEntidad() {
	}

	public RegistroEntidad(Integer id) {
		this.id = id;
	}

	public RegistroEntidad(Integer id, String placa, int cilindrajeCC, Date fechaEntrada) {
		this.id = id;
		this.placa = placa;
		this.cilindrajeCC = cilindrajeCC;
		this.fechaEntrada = fechaEntrada;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCilindrajeCC() {
		return cilindrajeCC;
	}

	public void setCilindrajeCC(int cilindrajecc) {
		this.cilindrajeCC = cilindrajecc;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public CeldaEntidad getCelda() {
		return celda;
	}

	public void setCelda(CeldaEntidad celda) {
		this.celda = celda;
	}

	public VehiculoEntidad getTipo() {
		return tipo;
	}

	public void setTipo(VehiculoEntidad tipo) {
		this.tipo = tipo;
	}

	public Collection<FacturaEntidad> getFacturaEntidadCollection() {
		return facturaEntidadCollection;
	}

	public void setFacturaEntidadCollection(Collection<FacturaEntidad> facturaEntidadCollection) {
		this.facturaEntidadCollection = facturaEntidadCollection;
	}
}