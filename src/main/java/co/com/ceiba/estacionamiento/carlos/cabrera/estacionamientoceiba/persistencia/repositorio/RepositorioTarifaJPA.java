package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.TarifaEntidad;

/**
 * @author carlos.cabrera
 *
 */
public interface RepositorioTarifaJPA extends CrudRepository<TarifaEntidad, Integer> {
}
