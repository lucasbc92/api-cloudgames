package org.senai.devinhouse.semana10.cloudgames.repository;

import org.senai.devinhouse.semana10.cloudgames.model.Plataforma;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends CrudRepository<Plataforma, Long> {
}
