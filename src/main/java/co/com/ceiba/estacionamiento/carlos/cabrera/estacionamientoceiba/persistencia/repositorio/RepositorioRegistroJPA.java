package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;

/**
 * @author carlos.cabrera
 *
 */
public interface RepositorioRegistroJPA extends CrudRepository<RegistroEntidad, Integer> {
	
	@Query("SELECT r FROM RegistroEntidad r where r.placa = ?1 and r.fechaSalida IS NULL ")
	public RegistroEntidad findByPlaca(String placa);
}
