package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.CeldaEntidad;

/**
 * @author carlos.cabrera
 *
 */
public interface RepositorioCeldaJPA extends CrudRepository<CeldaEntidad, Integer> {
}
