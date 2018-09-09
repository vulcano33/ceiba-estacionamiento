package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.util;

public enum TipoVehiculo {
	
	CARRO("CARRO", 1),
	MOTO("MOTO", 2);
	private String tipo;
	private Integer id;
	
	private TipoVehiculo(String tipo, Integer id) {
		this.tipo = tipo;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
}
