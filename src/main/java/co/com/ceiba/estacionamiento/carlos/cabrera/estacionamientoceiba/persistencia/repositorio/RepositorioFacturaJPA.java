package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;
import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.FacturaEntidad;

public interface RepositorioFacturaJPA extends CrudRepository<FacturaEntidad, Integer> {
}
