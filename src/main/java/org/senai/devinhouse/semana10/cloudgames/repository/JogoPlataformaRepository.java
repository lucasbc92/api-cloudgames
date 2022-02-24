package org.senai.devinhouse.semana10.cloudgames.repository;

import org.senai.devinhouse.semana10.cloudgames.model.JogoPlataforma;
import org.senai.devinhouse.semana10.cloudgames.model.JogoPlataformaKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoPlataformaRepository extends CrudRepository<JogoPlataforma, JogoPlataformaKey> {
}
