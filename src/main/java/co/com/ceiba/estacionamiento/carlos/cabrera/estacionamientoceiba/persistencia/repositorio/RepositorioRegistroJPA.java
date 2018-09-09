package co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.repositorio;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.estacionamiento.carlos.cabrera.estacionamientoceiba.persistencia.entidades.RegistroEntidad;

public interface RepositorioRegistroJPA extends CrudRepository<RegistroEntidad, Integer> {
}