package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Factura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Registro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.Vigilante;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.constructores.ConstructorRegistroDominio;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioFactura;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.dominio.repositorio.RepositorioRegistro;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.ParqueaderoConfiguracion;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.RegistroVehiculo;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.servicio.interfaces.ServicioRegistroVehiculo;

/**
 * @author carlos.cabrera
 *
 */
@Component
public class ServicioRegistroVehiculoImpl implements ServicioRegistroVehiculo {
	
	@Autowired
	private RepositorioRegistro repositorioRegistro;
	
	@Autowired
	private RepositorioFactura repositorioFactura;

	@Autowired
	private ParqueaderoConfiguracion configParqueadero;

	@Override
	public List<RegistroVehiculo> obtenerRegistros() {

		List<RegistroVehiculo> registrosVehiculo = new ArrayList<>();

		Vigilante vigilante = configParqueadero.getVigilante();

		for (Registro registro : vigilante.obtenerRegistros()) {
			RegistroVehiculo registroVehiculo = ConstructorRegistroDominio
					.convertirRegistroDominioARegVehiculo(registro);
			registrosVehiculo.add(registroVehiculo);
		}
		return registrosVehiculo;
	}

	@Override
	public RegistroVehiculo retirarRegistro(RegistroVehiculo registroVehiculo) {

		Vigilante vigilante = configParqueadero.getVigilante();
		Vehiculo vehiculo = new Vehiculo(registroVehiculo.getPlaca(), null);
		Registro registro = vigilante.retirarVehiculo(vehiculo);
		repositorioRegistro.retirarRegistro(registro);

		Factura factura = vigilante.generarFactura(registro);
		repositorioFactura.ingresarFactura(factura);
		
		registroVehiculo = ConstructorRegistroDominio.convertirRegistroDominioARegVehiculo(registro);
		registroVehiculo.setValorAPagar(factura.getValorAPagar());

		return registroVehiculo;
	}

	@Override
	public RegistroVehiculo ingresarRegistro(RegistroVehiculo registroVehiculo) {
		
		Vehiculo vehiculo = ConstructorRegistroDominio.convertirRegVehiculoSAVehiculoDominio(registroVehiculo);
		
		Vigilante vigilante = configParqueadero.getVigilante();
		Registro registro = vigilante.ingresarVehiculo(vehiculo);
		repositorioRegistro.ingresarRegistro(registro);
		registroVehiculo.setFechaEntrada(registro.getFechaEntrada());
		registroVehiculo.setTipoVehiculo(registroVehiculo.getTipoVehiculo().toUpperCase());
		registroVehiculo.setPlaca(registroVehiculo.getPlaca().toUpperCase());
		return registroVehiculo;
	}
}
